   M S B A M L   `   `   `  ����H  DCoderingenGui, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null-clr-namespace:CoderingenGuiCoderingenGui  5   	       CoderingenGui.MainWindow   5   	   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5   	   R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   -localclr-namespace:CoderingenGui     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      �  � RowDefinitions 5
   
   �� 5      �� 5      �� 5      .+�5   
   �� $��3��6   $��0��6'   $��0��67   $��Kies Codering��6D   .��5      �  � ColumnDefinitions 5      �� 5      �� 5      �� 5      .+�5      	�  	� 	GroupName$ 
radioArray��6   $��0��6k   $
��Blok��6{   $��Center=�6�   $��Center=�6�    d� 	IsChecked 65   ��  �� Path$ RadioArray[0]� �� Mode$ TwoWay=�6�   	� 5      -   5        $ 
radioArray��5      $��1��6k   $��Wissel��6{   $��Center=�6�   $��Center=�6�    65   �� $ RadioArray[1]�$ TwoWay=�6�   	� 5      $ 
radioArray��6   $��2��6k   $��Cijfer��6{   $��Center=�6�   $��Center=�6�    65   �� $ RadioArray[2]�$ TwoWay=�6�   5      5      �� 5   
   $��3��6   $��0��6'   $��1��67   $��
Invoertext��6D   .��5      �  5      �� 5      $��2* �6'   �� 5      $��1* �6'   �� 5       $��8* �6'   �� 5!      $��1* �6'   .+�5#      �� $��0��6   $��Center=�6*   $��Tekst:��6G   $��Center=�6U   $
��auto��6p   $
��auto��6~    �� 
IsReadOnly . 6�   �� 5$      -   5        $��	inputText��5$      $��2��6+   $��Stretch=�6;   $��Center=�6Y   $��35��6t    .  $
��0,41q�6�   5%      5&      �� 5'   
   $��3��6   $��0��6'   $��2��67   $��	Resultaat��6D   .��5(      �� -   5        $��
resultText��5(       . 6(   5)      5.      5/      