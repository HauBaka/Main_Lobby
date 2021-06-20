package com.HauvongMC.Modules.Join;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.md_5.bungee.api.chat.ClickEvent;
import net.minecraft.server.v1_8_R3.PacketDataSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutCustomPayload;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xyz.upperlevel.spigot.book.BookUtil;

public class Rule {
    public static void openBook(Player p, boolean confirm) {
        p.getInventory().setHeldItemSlot(0);
        ItemStack old = p.getItemInHand();
        ItemStack book = createRuleBook(p, confirm);
        p.getInventory().setItem(0, book);
        ByteBuf buf = Unpooled.buffer(256);
        buf.setByte(0, (byte)0);
        buf.writerIndex(1);
        PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
        CraftPlayer cp = (CraftPlayer) p;
        cp.getHandle().playerConnection.sendPacket(packet);
        p.getInventory().setItem(0, old);
    }
    private static ItemStack createRuleBook(Player p, boolean confirm) {
        if (confirm == true) {
            return BookUtil.writtenBook()
                    .author("HauvongMC")
                    .title("Rule")
                    .pages(
                            new BookUtil.PageBuilder()
                                    .add(
                                            BookUtil.TextBuilder.of("Luật lệ và hướng dẫn của LUCKYMCVN")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§bⓄ§c Quy định và hướng dẫn về về game")
                                                    .build()
                                    )
                                    .newLine()
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§bⓄ§c Quy định và hướng dẫn về tài khoản")
                                                    .build()
                                    )
                                    .newLine()
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§bⓄ§c Quy định và hướng dẫn về quyền cá nhân")
                                                    .build()
                                    )
                                    .newLine()
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§bⓄ§c Quy định về đạo đức")
                                                    .build()
                                    )
                                    .build(),
                            new BookUtil.PageBuilder()//page 2
                                    .add(
                                            BookUtil.TextBuilder.of("§0§l1: §c§lQuy định và hướng dẫn về về game")
                                                    .build()
                                    )
                                    .newLine()
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§01.1 §cKhông sử dụng các Client, Mod,... được cho là gian lận")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§01.2 §cBạn được tự do sử dụng các loại Pack, Shader,... nhưng không quy phạm quy định ở §01.1")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§2Khi thấy các hành vi vi phạm luật, bạn có thể tố cáo bằng cách sử dụng /report")
                                                    .build()
                                    )
                                    .build(),
                            new BookUtil.PageBuilder()//page 3
                                    .add(
                                            BookUtil.TextBuilder.of("§0§l2: §c§lQuy định và hướng dẫn về tài khoản")
                                                    .build()
                                    )
                                    .newLine()
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§02.1 §cKhông được nói mật khẩu cho ai biết kể cả Staff")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§02.2 §cMật khẩu là do bạn đặt ra, chúng tôi không đảm nhận việc đặt lại mật khẩu")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§2Bạn có thể thay đổi mật khẩu bằng cách sử dụng /resetpassword")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§2Khi bạn đổi tên, thông tin của bạn sẽ không chuyển sang tài khoảng mới")
                                                    .build()
                                    )
                                    .build(),
                            new BookUtil.PageBuilder()//page 4
                                    .add(
                                            BookUtil.TextBuilder.of("§0§l4: §c§lQuy định và hướng dẫn về quyền cá nhân")
                                                    .build()
                                    )
                                    .newLine()
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§04.1 §cTất cả thông tin cá nhân của bạn sẽ hoàn toàn được bảo mật, trừ các thông tin bạn ghi trong MXH")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§04.2 §cTiền bạn nạp tiền vào máy chủ, bạn có thể lấy lại thời hạn là 2 giờ")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§2Chúng tôi không chịu trách nhiệm về việc bạn truy cập vào các link người chơi khác chia sẻ")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§2Chúng tôi không chịu trách nhiệm về việc bạn nhập sai mệnh giá làm mất thẻ card")
                                                    .build()
                                    )
                                    .build(),
                            new BookUtil.PageBuilder()//page 5
                                    .add(
                                            BookUtil.TextBuilder.of("§0§l5: §c§lQuy định về đạo đức")
                                                    .build()
                                    )
                                    .newLine()
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§05.1 §cKhông được có hành vi trả thù")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§05.2 §cKhông được sử dụng các lời tục tĩu, đem những người không liên quan vào war")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§05.3 §cKhông được quảng cáo các thương thiệu cá nhân")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§05.4 §cKhông được mua bán trong máy chủ")
                                                    .build()
                                    )
                                    .build(),
                            new BookUtil.PageBuilder()//page 6
                                    .add(
                                            BookUtil.TextBuilder.of("§0§l6: §c§lQuy định và hướng dẫn khi Staff kiểm tra")
                                                    .build()
                                    )
                                    .newLine()
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§06.1 §cPhải luôn có sẵn phần mềm ANYDESK khi staff kiểm tra, bạn có thể bị xử tội oan khi không tải phần mềm.")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§06.2 §cNếu bạn out game trong quá trình kiểm tra bạn có thể bị xử tội oan.")
                                                    .build()
                                    )
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§06.3 §cBạn có quyền quay lại quá trình staff kiểm tra máy bạn.")
                                                    .build()
                                    )
                                    .build(),
                            new BookUtil.PageBuilder()//page 7
                                    .add(
                                            BookUtil.TextBuilder.of("§0Đến đây chắc hẳn bạn đã hiểu rõ luật của máy chủ, hãy nhấn vào xác nhận bên dưới để không còn hiển thị luật nữa")
                                                    .build()
                                    )
                                    .newLine()
                                    .newLine()
                                    .newLine()
                                    .add(
                                            BookUtil.TextBuilder.of("§a§l[XÁC NHẬN]")
                                                    .onClick(BookUtil.ClickAction.runCommand("/Rule confirm"))
                                                    .onHover(BookUtil.HoverAction.showText("§7Nhấp vào để xác nhận"))
                                                    .build()
                                    )
                                    .build()
                    )
                    .build();
        }
        return BookUtil.writtenBook()
                .author("HauvongMC")
                .title("Rule")
                .pages(
                        new BookUtil.PageBuilder()
                                .add(
                                        BookUtil.TextBuilder.of("Luật lệ và hướng dẫn của LUCKYMCVN")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§bⓄ§c Quy định và hướng dẫn về về game")
                                                .build()
                                )
                                .newLine()
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§bⓄ§c Quy định và hướng dẫn về tài khoản")
                                                .build()
                                )
                                .newLine()
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§bⓄ§c Quy định và hướng dẫn về quyền cá nhân")
                                                .build()
                                )
                                .newLine()
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§bⓄ§c Quy định về đạo đức")
                                                .build()
                                )
                                .build(),
                        new BookUtil.PageBuilder()//page 2
                                .add(
                                        BookUtil.TextBuilder.of("§0§l1: §c§lQuy định và hướng dẫn về về game")
                                                .build()
                                )
                                .newLine()
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§01.1 §cKhông sử dụng các Client, Mod,... được cho là gian lận")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§01.2 §cBạn được tự do sử dụng các loại Pack, Shader,... nhưng không quy phạm quy định ở §01.1")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§2Khi thấy các hành vi vi phạm luật, bạn có thể tố cáo bằng cách sử dụng /report")
                                                .build()
                                )
                                .build(),
                        new BookUtil.PageBuilder()//page 3
                                .add(
                                        BookUtil.TextBuilder.of("§0§l2: §c§lQuy định và hướng dẫn về tài khoản")
                                                .build()
                                )
                                .newLine()
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§02.1 §cKhông được nói mật khẩu cho ai biết kể cả Staff")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§02.2 §cMật khẩu là do bạn đặt ra, chúng tôi không đảm nhận việc đặt lại mật khẩu")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§2Bạn có thể thay đổi mật khẩu bằng cách sử dụng /resetpassword")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§2Khi bạn đổi tên, thông tin của bạn sẽ không chuyển sang tài khoảng mới")
                                                .build()
                                )
                                .build(),
                        new BookUtil.PageBuilder()//page 4
                                .add(
                                        BookUtil.TextBuilder.of("§0§l4: §c§lQuy định và hướng dẫn về quyền cá nhân")
                                                .build()
                                )
                                .newLine()
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§04.1 §cTất cả thông tin cá nhân của bạn sẽ hoàn toàn được bảo mật, trừ các thông tin bạn ghi trong MXH")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§04.2 §cTiền bạn nạp tiền vào máy chủ, bạn có thể lấy lại thời hạn là 2 giờ")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§2Chúng tôi không chịu trách nhiệm về việc bạn truy cập vào các link người chơi khác chia sẻ")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§2Chúng tôi không chịu trách nhiệm về việc bạn nhập sai mệnh giá làm mất thẻ card")
                                                .build()
                                )
                                .build(),
                        new BookUtil.PageBuilder()//page 5
                                .add(
                                        BookUtil.TextBuilder.of("§0§l5: §c§lQuy định về đạo đức")
                                                .build()
                                )
                                .newLine()
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§05.1 §cKhông được có hành vi trả thù")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§05.2 §cKhông được sử dụng các lời tục tĩu, đem những người không liên quan vào war")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§05.3 §cKhông được quảng cáo các thương thiệu cá nhân")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§05.4 §cKhông được mua bán trong máy chủ")
                                                .build()
                                )
                                .build(),
                        new BookUtil.PageBuilder()//page 6
                                .add(
                                        BookUtil.TextBuilder.of("§0§l6: §c§lQuy định và hướng dẫn khi Staff kiểm tra")
                                                .build()
                                )
                                .newLine()
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§06.1 §cPhải luôn có sẵn phần mềm ANYDESK khi staff kiểm tra, bạn có thể bị xử tội oan khi không tải phần mềm.")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§06.2 §cNếu bạn out game trong quá trình kiểm tra bạn có thể bị xử tội oan.")
                                                .build()
                                )
                                .newLine()
                                .add(
                                        BookUtil.TextBuilder.of("§06.3 §cBạn có quyền quay lại quá trình staff kiểm tra máy bạn.")
                                                .build()
                                )
                                .build()
                )
                .build();
    }
}
