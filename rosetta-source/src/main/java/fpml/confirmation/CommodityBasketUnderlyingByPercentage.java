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
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.Commodity;
import fpml.confirmation.CommodityBasketUnderlyingBase;
import fpml.confirmation.CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder;
import fpml.confirmation.CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilderImpl;
import fpml.confirmation.CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseImpl;
import fpml.confirmation.CommodityBasketUnderlyingByPercentage;
import fpml.confirmation.CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder;
import fpml.confirmation.CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilderImpl;
import fpml.confirmation.CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageImpl;
import fpml.confirmation.CommodityPricingDates;
import fpml.confirmation.PayerReceiverEnum;
import fpml.confirmation.meta.CommodityBasketUnderlyingByPercentageMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityBasketUnderlyingByPercentage", builder=CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityBasketUnderlyingByPercentage extends CommodityBasketUnderlyingBase {

	CommodityBasketUnderlyingByPercentageMeta metaData = new CommodityBasketUnderlyingByPercentageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If the Notional Quantity is specified in a unit that does not match the unit in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price unit into the Notional Quantity unit should be stated here. If there is no conversion, this element is not intended to be used.
	 */
	BigDecimal getConstituentWeight();

	/*********************** Build Methods  ***********************/
	CommodityBasketUnderlyingByPercentage build();
	
	CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder toBuilder();
	
	static CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder builder() {
		return new CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketUnderlyingByPercentage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBasketUnderlyingByPercentage> getType() {
		return CommodityBasketUnderlyingByPercentage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("direction"), PayerReceiverEnum.class, getDirection(), this);
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("constituentWeight"), BigDecimal.class, getConstituentWeight(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketUnderlyingByPercentageBuilder extends CommodityBasketUnderlyingByPercentage, CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilder {
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setDirection(PayerReceiverEnum direction);
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setCommodity(Commodity commodity);
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setPricingDates(CommodityPricingDates pricingDates);
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setId(String id);
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setConstituentWeight(BigDecimal constituentWeight);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("direction"), PayerReceiverEnum.class, getDirection(), this);
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("constituentWeight"), BigDecimal.class, getConstituentWeight(), this);
		}
		

		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketUnderlyingByPercentage  ***********************/
	class CommodityBasketUnderlyingByPercentageImpl extends CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseImpl implements CommodityBasketUnderlyingByPercentage {
		private final BigDecimal constituentWeight;
		
		protected CommodityBasketUnderlyingByPercentageImpl(CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder builder) {
			super(builder);
			this.constituentWeight = builder.getConstituentWeight();
		}
		
		@Override
		@RosettaAttribute("constituentWeight")
		public BigDecimal getConstituentWeight() {
			return constituentWeight;
		}
		
		@Override
		public CommodityBasketUnderlyingByPercentage build() {
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder toBuilder() {
			CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getConstituentWeight()).ifPresent(builder::setConstituentWeight);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketUnderlyingByPercentage _that = getType().cast(o);
		
			if (!Objects.equals(constituentWeight, _that.getConstituentWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (constituentWeight != null ? constituentWeight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketUnderlyingByPercentage {" +
				"constituentWeight=" + this.constituentWeight +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityBasketUnderlyingByPercentage  ***********************/
	class CommodityBasketUnderlyingByPercentageBuilderImpl extends CommodityBasketUnderlyingBase.CommodityBasketUnderlyingBaseBuilderImpl  implements CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder {
	
		protected BigDecimal constituentWeight;
	
		public CommodityBasketUnderlyingByPercentageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("constituentWeight")
		public BigDecimal getConstituentWeight() {
			return constituentWeight;
		}
		
		@Override
		@RosettaAttribute("direction")
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setDirection(PayerReceiverEnum direction) {
			this.direction = direction==null?null:direction;
			return this;
		}
		@Override
		@RosettaAttribute("commodity")
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setCommodity(Commodity commodity) {
			this.commodity = commodity==null?null:commodity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("pricingDates")
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setPricingDates(CommodityPricingDates pricingDates) {
			this.pricingDates = pricingDates==null?null:pricingDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("constituentWeight")
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder setConstituentWeight(BigDecimal constituentWeight) {
			this.constituentWeight = constituentWeight==null?null:constituentWeight;
			return this;
		}
		
		@Override
		public CommodityBasketUnderlyingByPercentage build() {
			return new CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageImpl(this);
		}
		
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getConstituentWeight()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder o = (CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder) other;
			
			
			merger.mergeBasic(getConstituentWeight(), o.getConstituentWeight(), this::setConstituentWeight);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketUnderlyingByPercentage _that = getType().cast(o);
		
			if (!Objects.equals(constituentWeight, _that.getConstituentWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (constituentWeight != null ? constituentWeight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketUnderlyingByPercentageBuilder {" +
				"constituentWeight=" + this.constituentWeight +
			'}' + " " + super.toString();
		}
	}
}
