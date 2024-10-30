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
import fpml.confirmation.QuotationRateTypeEnum;
import fpml.confirmation.SettlementRateSource;
import fpml.confirmation.YieldCurveMethod;
import fpml.confirmation.YieldCurveMethod.YieldCurveMethodBuilder;
import fpml.confirmation.YieldCurveMethod.YieldCurveMethodBuilderImpl;
import fpml.confirmation.YieldCurveMethod.YieldCurveMethodImpl;
import fpml.confirmation.meta.YieldCurveMethodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the parameters required for each of the ISDA defined yield curve methods for cash settlement.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="YieldCurveMethod", builder=YieldCurveMethod.YieldCurveMethodBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface YieldCurveMethod extends RosettaModelObject {

	YieldCurveMethodMeta metaData = new YieldCurveMethodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The method for obtaining a settlement rate. This may be from some information source (e.g. Reuters) or from a set of reference banks.
	 */
	SettlementRateSource getSettlementRateSource();
	/**
	 * Which rate quote is to be observed, either Bid, Mid, Offer or Exercising Party Pays. The meaning of Exercising Party Pays is defined in the 2000 ISDA Definitions, Section 17.2. Certain Definitions Relating to Cash Settlement, paragraph (j)
	 */
	QuotationRateTypeEnum getQuotationRateType();

	/*********************** Build Methods  ***********************/
	YieldCurveMethod build();
	
	YieldCurveMethod.YieldCurveMethodBuilder toBuilder();
	
	static YieldCurveMethod.YieldCurveMethodBuilder builder() {
		return new YieldCurveMethod.YieldCurveMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends YieldCurveMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends YieldCurveMethod> getType() {
		return YieldCurveMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementRateSource"), processor, SettlementRateSource.class, getSettlementRateSource());
		processor.processBasic(path.newSubPath("quotationRateType"), QuotationRateTypeEnum.class, getQuotationRateType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface YieldCurveMethodBuilder extends YieldCurveMethod, RosettaModelObjectBuilder {
		SettlementRateSource.SettlementRateSourceBuilder getOrCreateSettlementRateSource();
		SettlementRateSource.SettlementRateSourceBuilder getSettlementRateSource();
		YieldCurveMethod.YieldCurveMethodBuilder setSettlementRateSource(SettlementRateSource settlementRateSource);
		YieldCurveMethod.YieldCurveMethodBuilder setQuotationRateType(QuotationRateTypeEnum quotationRateType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementRateSource"), processor, SettlementRateSource.SettlementRateSourceBuilder.class, getSettlementRateSource());
			processor.processBasic(path.newSubPath("quotationRateType"), QuotationRateTypeEnum.class, getQuotationRateType(), this);
		}
		

		YieldCurveMethod.YieldCurveMethodBuilder prune();
	}

	/*********************** Immutable Implementation of YieldCurveMethod  ***********************/
	class YieldCurveMethodImpl implements YieldCurveMethod {
		private final SettlementRateSource settlementRateSource;
		private final QuotationRateTypeEnum quotationRateType;
		
		protected YieldCurveMethodImpl(YieldCurveMethod.YieldCurveMethodBuilder builder) {
			this.settlementRateSource = ofNullable(builder.getSettlementRateSource()).map(f->f.build()).orElse(null);
			this.quotationRateType = builder.getQuotationRateType();
		}
		
		@Override
		@RosettaAttribute("settlementRateSource")
		public SettlementRateSource getSettlementRateSource() {
			return settlementRateSource;
		}
		
		@Override
		@RosettaAttribute("quotationRateType")
		public QuotationRateTypeEnum getQuotationRateType() {
			return quotationRateType;
		}
		
		@Override
		public YieldCurveMethod build() {
			return this;
		}
		
		@Override
		public YieldCurveMethod.YieldCurveMethodBuilder toBuilder() {
			YieldCurveMethod.YieldCurveMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(YieldCurveMethod.YieldCurveMethodBuilder builder) {
			ofNullable(getSettlementRateSource()).ifPresent(builder::setSettlementRateSource);
			ofNullable(getQuotationRateType()).ifPresent(builder::setQuotationRateType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			YieldCurveMethod _that = getType().cast(o);
		
			if (!Objects.equals(settlementRateSource, _that.getSettlementRateSource())) return false;
			if (!Objects.equals(quotationRateType, _that.getQuotationRateType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementRateSource != null ? settlementRateSource.hashCode() : 0);
			_result = 31 * _result + (quotationRateType != null ? quotationRateType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "YieldCurveMethod {" +
				"settlementRateSource=" + this.settlementRateSource + ", " +
				"quotationRateType=" + this.quotationRateType +
			'}';
		}
	}

	/*********************** Builder Implementation of YieldCurveMethod  ***********************/
	class YieldCurveMethodBuilderImpl implements YieldCurveMethod.YieldCurveMethodBuilder {
	
		protected SettlementRateSource.SettlementRateSourceBuilder settlementRateSource;
		protected QuotationRateTypeEnum quotationRateType;
	
		public YieldCurveMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementRateSource")
		public SettlementRateSource.SettlementRateSourceBuilder getSettlementRateSource() {
			return settlementRateSource;
		}
		
		@Override
		public SettlementRateSource.SettlementRateSourceBuilder getOrCreateSettlementRateSource() {
			SettlementRateSource.SettlementRateSourceBuilder result;
			if (settlementRateSource!=null) {
				result = settlementRateSource;
			}
			else {
				result = settlementRateSource = SettlementRateSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quotationRateType")
		public QuotationRateTypeEnum getQuotationRateType() {
			return quotationRateType;
		}
		
		@Override
		@RosettaAttribute("settlementRateSource")
		public YieldCurveMethod.YieldCurveMethodBuilder setSettlementRateSource(SettlementRateSource settlementRateSource) {
			this.settlementRateSource = settlementRateSource==null?null:settlementRateSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quotationRateType")
		public YieldCurveMethod.YieldCurveMethodBuilder setQuotationRateType(QuotationRateTypeEnum quotationRateType) {
			this.quotationRateType = quotationRateType==null?null:quotationRateType;
			return this;
		}
		
		@Override
		public YieldCurveMethod build() {
			return new YieldCurveMethod.YieldCurveMethodImpl(this);
		}
		
		@Override
		public YieldCurveMethod.YieldCurveMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public YieldCurveMethod.YieldCurveMethodBuilder prune() {
			if (settlementRateSource!=null && !settlementRateSource.prune().hasData()) settlementRateSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementRateSource()!=null && getSettlementRateSource().hasData()) return true;
			if (getQuotationRateType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public YieldCurveMethod.YieldCurveMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			YieldCurveMethod.YieldCurveMethodBuilder o = (YieldCurveMethod.YieldCurveMethodBuilder) other;
			
			merger.mergeRosetta(getSettlementRateSource(), o.getSettlementRateSource(), this::setSettlementRateSource);
			
			merger.mergeBasic(getQuotationRateType(), o.getQuotationRateType(), this::setQuotationRateType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			YieldCurveMethod _that = getType().cast(o);
		
			if (!Objects.equals(settlementRateSource, _that.getSettlementRateSource())) return false;
			if (!Objects.equals(quotationRateType, _that.getQuotationRateType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementRateSource != null ? settlementRateSource.hashCode() : 0);
			_result = 31 * _result + (quotationRateType != null ? quotationRateType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "YieldCurveMethodBuilder {" +
				"settlementRateSource=" + this.settlementRateSource + ", " +
				"quotationRateType=" + this.quotationRateType +
			'}';
		}
	}
}
