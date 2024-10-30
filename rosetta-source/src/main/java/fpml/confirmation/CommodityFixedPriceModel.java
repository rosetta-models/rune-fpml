package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.CommodityFixedPriceModel;
import fpml.confirmation.CommodityFixedPriceModel.CommodityFixedPriceModelBuilder;
import fpml.confirmation.CommodityFixedPriceModel.CommodityFixedPriceModelBuilderImpl;
import fpml.confirmation.CommodityFixedPriceModel.CommodityFixedPriceModelImpl;
import fpml.confirmation.CommodityFixedPriceModelChoice;
import fpml.confirmation.CommodityFixedPriceSchedule;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.meta.CommodityFixedPriceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The different options for specifying the Fixed Price.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityFixedPriceModel", builder=CommodityFixedPriceModel.CommodityFixedPriceModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityFixedPriceModel extends RosettaModelObject {

	CommodityFixedPriceModelMeta metaData = new CommodityFixedPriceModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Allows the specification of a Fixed Price that varies over the life of the trade.
	 */
	CommodityFixedPriceSchedule getFixedPriceSchedule();
	CommodityFixedPriceModelChoice getCommodityFixedPriceModelChoice();
	/**
	 * The total amount of all fixed payments due during the term of the trade.
	 */
	NonNegativeMoney getTotalPrice();

	/*********************** Build Methods  ***********************/
	CommodityFixedPriceModel build();
	
	CommodityFixedPriceModel.CommodityFixedPriceModelBuilder toBuilder();
	
	static CommodityFixedPriceModel.CommodityFixedPriceModelBuilder builder() {
		return new CommodityFixedPriceModel.CommodityFixedPriceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFixedPriceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFixedPriceModel> getType() {
		return CommodityFixedPriceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fixedPriceSchedule"), processor, CommodityFixedPriceSchedule.class, getFixedPriceSchedule());
		processRosetta(path.newSubPath("commodityFixedPriceModelChoice"), processor, CommodityFixedPriceModelChoice.class, getCommodityFixedPriceModelChoice());
		processRosetta(path.newSubPath("totalPrice"), processor, NonNegativeMoney.class, getTotalPrice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFixedPriceModelBuilder extends CommodityFixedPriceModel, RosettaModelObjectBuilder {
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder getOrCreateFixedPriceSchedule();
		CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder getFixedPriceSchedule();
		CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder getOrCreateCommodityFixedPriceModelChoice();
		CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder getCommodityFixedPriceModelChoice();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateTotalPrice();
		NonNegativeMoney.NonNegativeMoneyBuilder getTotalPrice();
		CommodityFixedPriceModel.CommodityFixedPriceModelBuilder setFixedPriceSchedule(CommodityFixedPriceSchedule fixedPriceSchedule);
		CommodityFixedPriceModel.CommodityFixedPriceModelBuilder setCommodityFixedPriceModelChoice(CommodityFixedPriceModelChoice commodityFixedPriceModelChoice);
		CommodityFixedPriceModel.CommodityFixedPriceModelBuilder setTotalPrice(NonNegativeMoney totalPrice);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fixedPriceSchedule"), processor, CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder.class, getFixedPriceSchedule());
			processRosetta(path.newSubPath("commodityFixedPriceModelChoice"), processor, CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder.class, getCommodityFixedPriceModelChoice());
			processRosetta(path.newSubPath("totalPrice"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getTotalPrice());
		}
		

		CommodityFixedPriceModel.CommodityFixedPriceModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFixedPriceModel  ***********************/
	class CommodityFixedPriceModelImpl implements CommodityFixedPriceModel {
		private final CommodityFixedPriceSchedule fixedPriceSchedule;
		private final CommodityFixedPriceModelChoice commodityFixedPriceModelChoice;
		private final NonNegativeMoney totalPrice;
		
		protected CommodityFixedPriceModelImpl(CommodityFixedPriceModel.CommodityFixedPriceModelBuilder builder) {
			this.fixedPriceSchedule = ofNullable(builder.getFixedPriceSchedule()).map(f->f.build()).orElse(null);
			this.commodityFixedPriceModelChoice = ofNullable(builder.getCommodityFixedPriceModelChoice()).map(f->f.build()).orElse(null);
			this.totalPrice = ofNullable(builder.getTotalPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fixedPriceSchedule")
		public CommodityFixedPriceSchedule getFixedPriceSchedule() {
			return fixedPriceSchedule;
		}
		
		@Override
		@RosettaAttribute("commodityFixedPriceModelChoice")
		public CommodityFixedPriceModelChoice getCommodityFixedPriceModelChoice() {
			return commodityFixedPriceModelChoice;
		}
		
		@Override
		@RosettaAttribute("totalPrice")
		public NonNegativeMoney getTotalPrice() {
			return totalPrice;
		}
		
		@Override
		public CommodityFixedPriceModel build() {
			return this;
		}
		
		@Override
		public CommodityFixedPriceModel.CommodityFixedPriceModelBuilder toBuilder() {
			CommodityFixedPriceModel.CommodityFixedPriceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFixedPriceModel.CommodityFixedPriceModelBuilder builder) {
			ofNullable(getFixedPriceSchedule()).ifPresent(builder::setFixedPriceSchedule);
			ofNullable(getCommodityFixedPriceModelChoice()).ifPresent(builder::setCommodityFixedPriceModelChoice);
			ofNullable(getTotalPrice()).ifPresent(builder::setTotalPrice);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedPriceModel _that = getType().cast(o);
		
			if (!Objects.equals(fixedPriceSchedule, _that.getFixedPriceSchedule())) return false;
			if (!Objects.equals(commodityFixedPriceModelChoice, _that.getCommodityFixedPriceModelChoice())) return false;
			if (!Objects.equals(totalPrice, _that.getTotalPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedPriceSchedule != null ? fixedPriceSchedule.hashCode() : 0);
			_result = 31 * _result + (commodityFixedPriceModelChoice != null ? commodityFixedPriceModelChoice.hashCode() : 0);
			_result = 31 * _result + (totalPrice != null ? totalPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedPriceModel {" +
				"fixedPriceSchedule=" + this.fixedPriceSchedule + ", " +
				"commodityFixedPriceModelChoice=" + this.commodityFixedPriceModelChoice + ", " +
				"totalPrice=" + this.totalPrice +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFixedPriceModel  ***********************/
	class CommodityFixedPriceModelBuilderImpl implements CommodityFixedPriceModel.CommodityFixedPriceModelBuilder {
	
		protected CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder fixedPriceSchedule;
		protected CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder commodityFixedPriceModelChoice;
		protected NonNegativeMoney.NonNegativeMoneyBuilder totalPrice;
	
		public CommodityFixedPriceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixedPriceSchedule")
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder getFixedPriceSchedule() {
			return fixedPriceSchedule;
		}
		
		@Override
		public CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder getOrCreateFixedPriceSchedule() {
			CommodityFixedPriceSchedule.CommodityFixedPriceScheduleBuilder result;
			if (fixedPriceSchedule!=null) {
				result = fixedPriceSchedule;
			}
			else {
				result = fixedPriceSchedule = CommodityFixedPriceSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityFixedPriceModelChoice")
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder getCommodityFixedPriceModelChoice() {
			return commodityFixedPriceModelChoice;
		}
		
		@Override
		public CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder getOrCreateCommodityFixedPriceModelChoice() {
			CommodityFixedPriceModelChoice.CommodityFixedPriceModelChoiceBuilder result;
			if (commodityFixedPriceModelChoice!=null) {
				result = commodityFixedPriceModelChoice;
			}
			else {
				result = commodityFixedPriceModelChoice = CommodityFixedPriceModelChoice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("totalPrice")
		public NonNegativeMoney.NonNegativeMoneyBuilder getTotalPrice() {
			return totalPrice;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateTotalPrice() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (totalPrice!=null) {
				result = totalPrice;
			}
			else {
				result = totalPrice = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedPriceSchedule")
		public CommodityFixedPriceModel.CommodityFixedPriceModelBuilder setFixedPriceSchedule(CommodityFixedPriceSchedule fixedPriceSchedule) {
			this.fixedPriceSchedule = fixedPriceSchedule==null?null:fixedPriceSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFixedPriceModelChoice")
		public CommodityFixedPriceModel.CommodityFixedPriceModelBuilder setCommodityFixedPriceModelChoice(CommodityFixedPriceModelChoice commodityFixedPriceModelChoice) {
			this.commodityFixedPriceModelChoice = commodityFixedPriceModelChoice==null?null:commodityFixedPriceModelChoice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("totalPrice")
		public CommodityFixedPriceModel.CommodityFixedPriceModelBuilder setTotalPrice(NonNegativeMoney totalPrice) {
			this.totalPrice = totalPrice==null?null:totalPrice.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFixedPriceModel build() {
			return new CommodityFixedPriceModel.CommodityFixedPriceModelImpl(this);
		}
		
		@Override
		public CommodityFixedPriceModel.CommodityFixedPriceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedPriceModel.CommodityFixedPriceModelBuilder prune() {
			if (fixedPriceSchedule!=null && !fixedPriceSchedule.prune().hasData()) fixedPriceSchedule = null;
			if (commodityFixedPriceModelChoice!=null && !commodityFixedPriceModelChoice.prune().hasData()) commodityFixedPriceModelChoice = null;
			if (totalPrice!=null && !totalPrice.prune().hasData()) totalPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixedPriceSchedule()!=null && getFixedPriceSchedule().hasData()) return true;
			if (getCommodityFixedPriceModelChoice()!=null && getCommodityFixedPriceModelChoice().hasData()) return true;
			if (getTotalPrice()!=null && getTotalPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFixedPriceModel.CommodityFixedPriceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFixedPriceModel.CommodityFixedPriceModelBuilder o = (CommodityFixedPriceModel.CommodityFixedPriceModelBuilder) other;
			
			merger.mergeRosetta(getFixedPriceSchedule(), o.getFixedPriceSchedule(), this::setFixedPriceSchedule);
			merger.mergeRosetta(getCommodityFixedPriceModelChoice(), o.getCommodityFixedPriceModelChoice(), this::setCommodityFixedPriceModelChoice);
			merger.mergeRosetta(getTotalPrice(), o.getTotalPrice(), this::setTotalPrice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFixedPriceModel _that = getType().cast(o);
		
			if (!Objects.equals(fixedPriceSchedule, _that.getFixedPriceSchedule())) return false;
			if (!Objects.equals(commodityFixedPriceModelChoice, _that.getCommodityFixedPriceModelChoice())) return false;
			if (!Objects.equals(totalPrice, _that.getTotalPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixedPriceSchedule != null ? fixedPriceSchedule.hashCode() : 0);
			_result = 31 * _result + (commodityFixedPriceModelChoice != null ? commodityFixedPriceModelChoice.hashCode() : 0);
			_result = 31 * _result + (totalPrice != null ? totalPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFixedPriceModelBuilder {" +
				"fixedPriceSchedule=" + this.fixedPriceSchedule + ", " +
				"commodityFixedPriceModelChoice=" + this.commodityFixedPriceModelChoice + ", " +
				"totalPrice=" + this.totalPrice +
			'}';
		}
	}
}
