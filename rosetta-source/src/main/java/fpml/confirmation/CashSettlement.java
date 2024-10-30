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
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CashPriceMethod;
import fpml.confirmation.CashSettlement;
import fpml.confirmation.CashSettlement.CashSettlementBuilder;
import fpml.confirmation.CashSettlement.CashSettlementBuilderImpl;
import fpml.confirmation.CashSettlement.CashSettlementImpl;
import fpml.confirmation.CashSettlementPaymentDate;
import fpml.confirmation.CrossCurrencyMethod;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.YieldCurveMethod;
import fpml.confirmation.meta.CashSettlementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type to define the cash settlement terms for a product where cash settlement is applicable.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CashSettlement", builder=CashSettlement.CashSettlementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CashSettlement extends RosettaModelObject {

	CashSettlementMeta metaData = new CashSettlementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The time of the cash settlement valuation date when the cash settlement amount will be determined according to the cash settlement method if the parties have not otherwise been able to agree the cash settlement amount.
	 */
	BusinessCenterTime getCashSettlementValuationTime();
	/**
	 * The date on which the cash settlement amount will be determined according to the cash settlement method if the parties have not otherwise been able to agree the cash settlement amount.
	 */
	RelativeDateOffset getCashSettlementValuationDate();
	/**
	 * The date on which the cash settlement amount will be paid, subject to adjustment in accordance with any applicable business day convention. This component would not be present for a mandatory early termination provision where the cash settlement payment date is the mandatory early termination date.
	 */
	CashSettlementPaymentDate getCashSettlementPaymentDate();
	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (a).
	 */
	CashPriceMethod getCashPriceMethod();
	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (b).
	 */
	CashPriceMethod getCashPriceAlternateMethod();
	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (c).
	 */
	YieldCurveMethod getParYieldCurveAdjustedMethod();
	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (d).
	 */
	YieldCurveMethod getZeroCouponYieldAdjustedMethod();
	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (e).
	 */
	YieldCurveMethod getParYieldCurveUnadjustedMethod();
	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (f) (published in Supplement number 23).
	 */
	CrossCurrencyMethod getCrossCurrencyMethod();
	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (g) (published in Supplement number 28).
	 */
	YieldCurveMethod getCollateralizedCashPriceMethod();
	String getId();

	/*********************** Build Methods  ***********************/
	CashSettlement build();
	
	CashSettlement.CashSettlementBuilder toBuilder();
	
	static CashSettlement.CashSettlementBuilder builder() {
		return new CashSettlement.CashSettlementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashSettlement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CashSettlement> getType() {
		return CashSettlement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashSettlementValuationTime"), processor, BusinessCenterTime.class, getCashSettlementValuationTime());
		processRosetta(path.newSubPath("cashSettlementValuationDate"), processor, RelativeDateOffset.class, getCashSettlementValuationDate());
		processRosetta(path.newSubPath("cashSettlementPaymentDate"), processor, CashSettlementPaymentDate.class, getCashSettlementPaymentDate());
		processRosetta(path.newSubPath("cashPriceMethod"), processor, CashPriceMethod.class, getCashPriceMethod());
		processRosetta(path.newSubPath("cashPriceAlternateMethod"), processor, CashPriceMethod.class, getCashPriceAlternateMethod());
		processRosetta(path.newSubPath("parYieldCurveAdjustedMethod"), processor, YieldCurveMethod.class, getParYieldCurveAdjustedMethod());
		processRosetta(path.newSubPath("zeroCouponYieldAdjustedMethod"), processor, YieldCurveMethod.class, getZeroCouponYieldAdjustedMethod());
		processRosetta(path.newSubPath("parYieldCurveUnadjustedMethod"), processor, YieldCurveMethod.class, getParYieldCurveUnadjustedMethod());
		processRosetta(path.newSubPath("crossCurrencyMethod"), processor, CrossCurrencyMethod.class, getCrossCurrencyMethod());
		processRosetta(path.newSubPath("collateralizedCashPriceMethod"), processor, YieldCurveMethod.class, getCollateralizedCashPriceMethod());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashSettlementBuilder extends CashSettlement, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateCashSettlementValuationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getCashSettlementValuationTime();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateCashSettlementValuationDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getCashSettlementValuationDate();
		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder getOrCreateCashSettlementPaymentDate();
		CashSettlementPaymentDate.CashSettlementPaymentDateBuilder getCashSettlementPaymentDate();
		CashPriceMethod.CashPriceMethodBuilder getOrCreateCashPriceMethod();
		CashPriceMethod.CashPriceMethodBuilder getCashPriceMethod();
		CashPriceMethod.CashPriceMethodBuilder getOrCreateCashPriceAlternateMethod();
		CashPriceMethod.CashPriceMethodBuilder getCashPriceAlternateMethod();
		YieldCurveMethod.YieldCurveMethodBuilder getOrCreateParYieldCurveAdjustedMethod();
		YieldCurveMethod.YieldCurveMethodBuilder getParYieldCurveAdjustedMethod();
		YieldCurveMethod.YieldCurveMethodBuilder getOrCreateZeroCouponYieldAdjustedMethod();
		YieldCurveMethod.YieldCurveMethodBuilder getZeroCouponYieldAdjustedMethod();
		YieldCurveMethod.YieldCurveMethodBuilder getOrCreateParYieldCurveUnadjustedMethod();
		YieldCurveMethod.YieldCurveMethodBuilder getParYieldCurveUnadjustedMethod();
		CrossCurrencyMethod.CrossCurrencyMethodBuilder getOrCreateCrossCurrencyMethod();
		CrossCurrencyMethod.CrossCurrencyMethodBuilder getCrossCurrencyMethod();
		YieldCurveMethod.YieldCurveMethodBuilder getOrCreateCollateralizedCashPriceMethod();
		YieldCurveMethod.YieldCurveMethodBuilder getCollateralizedCashPriceMethod();
		CashSettlement.CashSettlementBuilder setCashSettlementValuationTime(BusinessCenterTime cashSettlementValuationTime);
		CashSettlement.CashSettlementBuilder setCashSettlementValuationDate(RelativeDateOffset cashSettlementValuationDate);
		CashSettlement.CashSettlementBuilder setCashSettlementPaymentDate(CashSettlementPaymentDate cashSettlementPaymentDate);
		CashSettlement.CashSettlementBuilder setCashPriceMethod(CashPriceMethod cashPriceMethod);
		CashSettlement.CashSettlementBuilder setCashPriceAlternateMethod(CashPriceMethod cashPriceAlternateMethod);
		CashSettlement.CashSettlementBuilder setParYieldCurveAdjustedMethod(YieldCurveMethod parYieldCurveAdjustedMethod);
		CashSettlement.CashSettlementBuilder setZeroCouponYieldAdjustedMethod(YieldCurveMethod zeroCouponYieldAdjustedMethod);
		CashSettlement.CashSettlementBuilder setParYieldCurveUnadjustedMethod(YieldCurveMethod parYieldCurveUnadjustedMethod);
		CashSettlement.CashSettlementBuilder setCrossCurrencyMethod(CrossCurrencyMethod crossCurrencyMethod);
		CashSettlement.CashSettlementBuilder setCollateralizedCashPriceMethod(YieldCurveMethod collateralizedCashPriceMethod);
		CashSettlement.CashSettlementBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashSettlementValuationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getCashSettlementValuationTime());
			processRosetta(path.newSubPath("cashSettlementValuationDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getCashSettlementValuationDate());
			processRosetta(path.newSubPath("cashSettlementPaymentDate"), processor, CashSettlementPaymentDate.CashSettlementPaymentDateBuilder.class, getCashSettlementPaymentDate());
			processRosetta(path.newSubPath("cashPriceMethod"), processor, CashPriceMethod.CashPriceMethodBuilder.class, getCashPriceMethod());
			processRosetta(path.newSubPath("cashPriceAlternateMethod"), processor, CashPriceMethod.CashPriceMethodBuilder.class, getCashPriceAlternateMethod());
			processRosetta(path.newSubPath("parYieldCurveAdjustedMethod"), processor, YieldCurveMethod.YieldCurveMethodBuilder.class, getParYieldCurveAdjustedMethod());
			processRosetta(path.newSubPath("zeroCouponYieldAdjustedMethod"), processor, YieldCurveMethod.YieldCurveMethodBuilder.class, getZeroCouponYieldAdjustedMethod());
			processRosetta(path.newSubPath("parYieldCurveUnadjustedMethod"), processor, YieldCurveMethod.YieldCurveMethodBuilder.class, getParYieldCurveUnadjustedMethod());
			processRosetta(path.newSubPath("crossCurrencyMethod"), processor, CrossCurrencyMethod.CrossCurrencyMethodBuilder.class, getCrossCurrencyMethod());
			processRosetta(path.newSubPath("collateralizedCashPriceMethod"), processor, YieldCurveMethod.YieldCurveMethodBuilder.class, getCollateralizedCashPriceMethod());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CashSettlement.CashSettlementBuilder prune();
	}

	/*********************** Immutable Implementation of CashSettlement  ***********************/
	class CashSettlementImpl implements CashSettlement {
		private final BusinessCenterTime cashSettlementValuationTime;
		private final RelativeDateOffset cashSettlementValuationDate;
		private final CashSettlementPaymentDate cashSettlementPaymentDate;
		private final CashPriceMethod cashPriceMethod;
		private final CashPriceMethod cashPriceAlternateMethod;
		private final YieldCurveMethod parYieldCurveAdjustedMethod;
		private final YieldCurveMethod zeroCouponYieldAdjustedMethod;
		private final YieldCurveMethod parYieldCurveUnadjustedMethod;
		private final CrossCurrencyMethod crossCurrencyMethod;
		private final YieldCurveMethod collateralizedCashPriceMethod;
		private final String id;
		
		protected CashSettlementImpl(CashSettlement.CashSettlementBuilder builder) {
			this.cashSettlementValuationTime = ofNullable(builder.getCashSettlementValuationTime()).map(f->f.build()).orElse(null);
			this.cashSettlementValuationDate = ofNullable(builder.getCashSettlementValuationDate()).map(f->f.build()).orElse(null);
			this.cashSettlementPaymentDate = ofNullable(builder.getCashSettlementPaymentDate()).map(f->f.build()).orElse(null);
			this.cashPriceMethod = ofNullable(builder.getCashPriceMethod()).map(f->f.build()).orElse(null);
			this.cashPriceAlternateMethod = ofNullable(builder.getCashPriceAlternateMethod()).map(f->f.build()).orElse(null);
			this.parYieldCurveAdjustedMethod = ofNullable(builder.getParYieldCurveAdjustedMethod()).map(f->f.build()).orElse(null);
			this.zeroCouponYieldAdjustedMethod = ofNullable(builder.getZeroCouponYieldAdjustedMethod()).map(f->f.build()).orElse(null);
			this.parYieldCurveUnadjustedMethod = ofNullable(builder.getParYieldCurveUnadjustedMethod()).map(f->f.build()).orElse(null);
			this.crossCurrencyMethod = ofNullable(builder.getCrossCurrencyMethod()).map(f->f.build()).orElse(null);
			this.collateralizedCashPriceMethod = ofNullable(builder.getCollateralizedCashPriceMethod()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("cashSettlementValuationTime")
		public BusinessCenterTime getCashSettlementValuationTime() {
			return cashSettlementValuationTime;
		}
		
		@Override
		@RosettaAttribute("cashSettlementValuationDate")
		public RelativeDateOffset getCashSettlementValuationDate() {
			return cashSettlementValuationDate;
		}
		
		@Override
		@RosettaAttribute("cashSettlementPaymentDate")
		public CashSettlementPaymentDate getCashSettlementPaymentDate() {
			return cashSettlementPaymentDate;
		}
		
		@Override
		@RosettaAttribute("cashPriceMethod")
		public CashPriceMethod getCashPriceMethod() {
			return cashPriceMethod;
		}
		
		@Override
		@RosettaAttribute("cashPriceAlternateMethod")
		public CashPriceMethod getCashPriceAlternateMethod() {
			return cashPriceAlternateMethod;
		}
		
		@Override
		@RosettaAttribute("parYieldCurveAdjustedMethod")
		public YieldCurveMethod getParYieldCurveAdjustedMethod() {
			return parYieldCurveAdjustedMethod;
		}
		
		@Override
		@RosettaAttribute("zeroCouponYieldAdjustedMethod")
		public YieldCurveMethod getZeroCouponYieldAdjustedMethod() {
			return zeroCouponYieldAdjustedMethod;
		}
		
		@Override
		@RosettaAttribute("parYieldCurveUnadjustedMethod")
		public YieldCurveMethod getParYieldCurveUnadjustedMethod() {
			return parYieldCurveUnadjustedMethod;
		}
		
		@Override
		@RosettaAttribute("crossCurrencyMethod")
		public CrossCurrencyMethod getCrossCurrencyMethod() {
			return crossCurrencyMethod;
		}
		
		@Override
		@RosettaAttribute("collateralizedCashPriceMethod")
		public YieldCurveMethod getCollateralizedCashPriceMethod() {
			return collateralizedCashPriceMethod;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CashSettlement build() {
			return this;
		}
		
		@Override
		public CashSettlement.CashSettlementBuilder toBuilder() {
			CashSettlement.CashSettlementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashSettlement.CashSettlementBuilder builder) {
			ofNullable(getCashSettlementValuationTime()).ifPresent(builder::setCashSettlementValuationTime);
			ofNullable(getCashSettlementValuationDate()).ifPresent(builder::setCashSettlementValuationDate);
			ofNullable(getCashSettlementPaymentDate()).ifPresent(builder::setCashSettlementPaymentDate);
			ofNullable(getCashPriceMethod()).ifPresent(builder::setCashPriceMethod);
			ofNullable(getCashPriceAlternateMethod()).ifPresent(builder::setCashPriceAlternateMethod);
			ofNullable(getParYieldCurveAdjustedMethod()).ifPresent(builder::setParYieldCurveAdjustedMethod);
			ofNullable(getZeroCouponYieldAdjustedMethod()).ifPresent(builder::setZeroCouponYieldAdjustedMethod);
			ofNullable(getParYieldCurveUnadjustedMethod()).ifPresent(builder::setParYieldCurveUnadjustedMethod);
			ofNullable(getCrossCurrencyMethod()).ifPresent(builder::setCrossCurrencyMethod);
			ofNullable(getCollateralizedCashPriceMethod()).ifPresent(builder::setCollateralizedCashPriceMethod);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlement _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementValuationTime, _that.getCashSettlementValuationTime())) return false;
			if (!Objects.equals(cashSettlementValuationDate, _that.getCashSettlementValuationDate())) return false;
			if (!Objects.equals(cashSettlementPaymentDate, _that.getCashSettlementPaymentDate())) return false;
			if (!Objects.equals(cashPriceMethod, _that.getCashPriceMethod())) return false;
			if (!Objects.equals(cashPriceAlternateMethod, _that.getCashPriceAlternateMethod())) return false;
			if (!Objects.equals(parYieldCurveAdjustedMethod, _that.getParYieldCurveAdjustedMethod())) return false;
			if (!Objects.equals(zeroCouponYieldAdjustedMethod, _that.getZeroCouponYieldAdjustedMethod())) return false;
			if (!Objects.equals(parYieldCurveUnadjustedMethod, _that.getParYieldCurveUnadjustedMethod())) return false;
			if (!Objects.equals(crossCurrencyMethod, _that.getCrossCurrencyMethod())) return false;
			if (!Objects.equals(collateralizedCashPriceMethod, _that.getCollateralizedCashPriceMethod())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementValuationTime != null ? cashSettlementValuationTime.hashCode() : 0);
			_result = 31 * _result + (cashSettlementValuationDate != null ? cashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (cashSettlementPaymentDate != null ? cashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (cashPriceMethod != null ? cashPriceMethod.hashCode() : 0);
			_result = 31 * _result + (cashPriceAlternateMethod != null ? cashPriceAlternateMethod.hashCode() : 0);
			_result = 31 * _result + (parYieldCurveAdjustedMethod != null ? parYieldCurveAdjustedMethod.hashCode() : 0);
			_result = 31 * _result + (zeroCouponYieldAdjustedMethod != null ? zeroCouponYieldAdjustedMethod.hashCode() : 0);
			_result = 31 * _result + (parYieldCurveUnadjustedMethod != null ? parYieldCurveUnadjustedMethod.hashCode() : 0);
			_result = 31 * _result + (crossCurrencyMethod != null ? crossCurrencyMethod.hashCode() : 0);
			_result = 31 * _result + (collateralizedCashPriceMethod != null ? collateralizedCashPriceMethod.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlement {" +
				"cashSettlementValuationTime=" + this.cashSettlementValuationTime + ", " +
				"cashSettlementValuationDate=" + this.cashSettlementValuationDate + ", " +
				"cashSettlementPaymentDate=" + this.cashSettlementPaymentDate + ", " +
				"cashPriceMethod=" + this.cashPriceMethod + ", " +
				"cashPriceAlternateMethod=" + this.cashPriceAlternateMethod + ", " +
				"parYieldCurveAdjustedMethod=" + this.parYieldCurveAdjustedMethod + ", " +
				"zeroCouponYieldAdjustedMethod=" + this.zeroCouponYieldAdjustedMethod + ", " +
				"parYieldCurveUnadjustedMethod=" + this.parYieldCurveUnadjustedMethod + ", " +
				"crossCurrencyMethod=" + this.crossCurrencyMethod + ", " +
				"collateralizedCashPriceMethod=" + this.collateralizedCashPriceMethod + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CashSettlement  ***********************/
	class CashSettlementBuilderImpl implements CashSettlement.CashSettlementBuilder {
	
		protected BusinessCenterTime.BusinessCenterTimeBuilder cashSettlementValuationTime;
		protected RelativeDateOffset.RelativeDateOffsetBuilder cashSettlementValuationDate;
		protected CashSettlementPaymentDate.CashSettlementPaymentDateBuilder cashSettlementPaymentDate;
		protected CashPriceMethod.CashPriceMethodBuilder cashPriceMethod;
		protected CashPriceMethod.CashPriceMethodBuilder cashPriceAlternateMethod;
		protected YieldCurveMethod.YieldCurveMethodBuilder parYieldCurveAdjustedMethod;
		protected YieldCurveMethod.YieldCurveMethodBuilder zeroCouponYieldAdjustedMethod;
		protected YieldCurveMethod.YieldCurveMethodBuilder parYieldCurveUnadjustedMethod;
		protected CrossCurrencyMethod.CrossCurrencyMethodBuilder crossCurrencyMethod;
		protected YieldCurveMethod.YieldCurveMethodBuilder collateralizedCashPriceMethod;
		protected String id;
	
		public CashSettlementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("cashSettlementValuationTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getCashSettlementValuationTime() {
			return cashSettlementValuationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateCashSettlementValuationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (cashSettlementValuationTime!=null) {
				result = cashSettlementValuationTime;
			}
			else {
				result = cashSettlementValuationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlementValuationDate")
		public RelativeDateOffset.RelativeDateOffsetBuilder getCashSettlementValuationDate() {
			return cashSettlementValuationDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateCashSettlementValuationDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (cashSettlementValuationDate!=null) {
				result = cashSettlementValuationDate;
			}
			else {
				result = cashSettlementValuationDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlementPaymentDate")
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder getCashSettlementPaymentDate() {
			return cashSettlementPaymentDate;
		}
		
		@Override
		public CashSettlementPaymentDate.CashSettlementPaymentDateBuilder getOrCreateCashSettlementPaymentDate() {
			CashSettlementPaymentDate.CashSettlementPaymentDateBuilder result;
			if (cashSettlementPaymentDate!=null) {
				result = cashSettlementPaymentDate;
			}
			else {
				result = cashSettlementPaymentDate = CashSettlementPaymentDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashPriceMethod")
		public CashPriceMethod.CashPriceMethodBuilder getCashPriceMethod() {
			return cashPriceMethod;
		}
		
		@Override
		public CashPriceMethod.CashPriceMethodBuilder getOrCreateCashPriceMethod() {
			CashPriceMethod.CashPriceMethodBuilder result;
			if (cashPriceMethod!=null) {
				result = cashPriceMethod;
			}
			else {
				result = cashPriceMethod = CashPriceMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashPriceAlternateMethod")
		public CashPriceMethod.CashPriceMethodBuilder getCashPriceAlternateMethod() {
			return cashPriceAlternateMethod;
		}
		
		@Override
		public CashPriceMethod.CashPriceMethodBuilder getOrCreateCashPriceAlternateMethod() {
			CashPriceMethod.CashPriceMethodBuilder result;
			if (cashPriceAlternateMethod!=null) {
				result = cashPriceAlternateMethod;
			}
			else {
				result = cashPriceAlternateMethod = CashPriceMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("parYieldCurveAdjustedMethod")
		public YieldCurveMethod.YieldCurveMethodBuilder getParYieldCurveAdjustedMethod() {
			return parYieldCurveAdjustedMethod;
		}
		
		@Override
		public YieldCurveMethod.YieldCurveMethodBuilder getOrCreateParYieldCurveAdjustedMethod() {
			YieldCurveMethod.YieldCurveMethodBuilder result;
			if (parYieldCurveAdjustedMethod!=null) {
				result = parYieldCurveAdjustedMethod;
			}
			else {
				result = parYieldCurveAdjustedMethod = YieldCurveMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("zeroCouponYieldAdjustedMethod")
		public YieldCurveMethod.YieldCurveMethodBuilder getZeroCouponYieldAdjustedMethod() {
			return zeroCouponYieldAdjustedMethod;
		}
		
		@Override
		public YieldCurveMethod.YieldCurveMethodBuilder getOrCreateZeroCouponYieldAdjustedMethod() {
			YieldCurveMethod.YieldCurveMethodBuilder result;
			if (zeroCouponYieldAdjustedMethod!=null) {
				result = zeroCouponYieldAdjustedMethod;
			}
			else {
				result = zeroCouponYieldAdjustedMethod = YieldCurveMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("parYieldCurveUnadjustedMethod")
		public YieldCurveMethod.YieldCurveMethodBuilder getParYieldCurveUnadjustedMethod() {
			return parYieldCurveUnadjustedMethod;
		}
		
		@Override
		public YieldCurveMethod.YieldCurveMethodBuilder getOrCreateParYieldCurveUnadjustedMethod() {
			YieldCurveMethod.YieldCurveMethodBuilder result;
			if (parYieldCurveUnadjustedMethod!=null) {
				result = parYieldCurveUnadjustedMethod;
			}
			else {
				result = parYieldCurveUnadjustedMethod = YieldCurveMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("crossCurrencyMethod")
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder getCrossCurrencyMethod() {
			return crossCurrencyMethod;
		}
		
		@Override
		public CrossCurrencyMethod.CrossCurrencyMethodBuilder getOrCreateCrossCurrencyMethod() {
			CrossCurrencyMethod.CrossCurrencyMethodBuilder result;
			if (crossCurrencyMethod!=null) {
				result = crossCurrencyMethod;
			}
			else {
				result = crossCurrencyMethod = CrossCurrencyMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralizedCashPriceMethod")
		public YieldCurveMethod.YieldCurveMethodBuilder getCollateralizedCashPriceMethod() {
			return collateralizedCashPriceMethod;
		}
		
		@Override
		public YieldCurveMethod.YieldCurveMethodBuilder getOrCreateCollateralizedCashPriceMethod() {
			YieldCurveMethod.YieldCurveMethodBuilder result;
			if (collateralizedCashPriceMethod!=null) {
				result = collateralizedCashPriceMethod;
			}
			else {
				result = collateralizedCashPriceMethod = YieldCurveMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("cashSettlementValuationTime")
		public CashSettlement.CashSettlementBuilder setCashSettlementValuationTime(BusinessCenterTime cashSettlementValuationTime) {
			this.cashSettlementValuationTime = cashSettlementValuationTime==null?null:cashSettlementValuationTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashSettlementValuationDate")
		public CashSettlement.CashSettlementBuilder setCashSettlementValuationDate(RelativeDateOffset cashSettlementValuationDate) {
			this.cashSettlementValuationDate = cashSettlementValuationDate==null?null:cashSettlementValuationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashSettlementPaymentDate")
		public CashSettlement.CashSettlementBuilder setCashSettlementPaymentDate(CashSettlementPaymentDate cashSettlementPaymentDate) {
			this.cashSettlementPaymentDate = cashSettlementPaymentDate==null?null:cashSettlementPaymentDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashPriceMethod")
		public CashSettlement.CashSettlementBuilder setCashPriceMethod(CashPriceMethod cashPriceMethod) {
			this.cashPriceMethod = cashPriceMethod==null?null:cashPriceMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cashPriceAlternateMethod")
		public CashSettlement.CashSettlementBuilder setCashPriceAlternateMethod(CashPriceMethod cashPriceAlternateMethod) {
			this.cashPriceAlternateMethod = cashPriceAlternateMethod==null?null:cashPriceAlternateMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("parYieldCurveAdjustedMethod")
		public CashSettlement.CashSettlementBuilder setParYieldCurveAdjustedMethod(YieldCurveMethod parYieldCurveAdjustedMethod) {
			this.parYieldCurveAdjustedMethod = parYieldCurveAdjustedMethod==null?null:parYieldCurveAdjustedMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("zeroCouponYieldAdjustedMethod")
		public CashSettlement.CashSettlementBuilder setZeroCouponYieldAdjustedMethod(YieldCurveMethod zeroCouponYieldAdjustedMethod) {
			this.zeroCouponYieldAdjustedMethod = zeroCouponYieldAdjustedMethod==null?null:zeroCouponYieldAdjustedMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("parYieldCurveUnadjustedMethod")
		public CashSettlement.CashSettlementBuilder setParYieldCurveUnadjustedMethod(YieldCurveMethod parYieldCurveUnadjustedMethod) {
			this.parYieldCurveUnadjustedMethod = parYieldCurveUnadjustedMethod==null?null:parYieldCurveUnadjustedMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("crossCurrencyMethod")
		public CashSettlement.CashSettlementBuilder setCrossCurrencyMethod(CrossCurrencyMethod crossCurrencyMethod) {
			this.crossCurrencyMethod = crossCurrencyMethod==null?null:crossCurrencyMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("collateralizedCashPriceMethod")
		public CashSettlement.CashSettlementBuilder setCollateralizedCashPriceMethod(YieldCurveMethod collateralizedCashPriceMethod) {
			this.collateralizedCashPriceMethod = collateralizedCashPriceMethod==null?null:collateralizedCashPriceMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CashSettlement.CashSettlementBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CashSettlement build() {
			return new CashSettlement.CashSettlementImpl(this);
		}
		
		@Override
		public CashSettlement.CashSettlementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlement.CashSettlementBuilder prune() {
			if (cashSettlementValuationTime!=null && !cashSettlementValuationTime.prune().hasData()) cashSettlementValuationTime = null;
			if (cashSettlementValuationDate!=null && !cashSettlementValuationDate.prune().hasData()) cashSettlementValuationDate = null;
			if (cashSettlementPaymentDate!=null && !cashSettlementPaymentDate.prune().hasData()) cashSettlementPaymentDate = null;
			if (cashPriceMethod!=null && !cashPriceMethod.prune().hasData()) cashPriceMethod = null;
			if (cashPriceAlternateMethod!=null && !cashPriceAlternateMethod.prune().hasData()) cashPriceAlternateMethod = null;
			if (parYieldCurveAdjustedMethod!=null && !parYieldCurveAdjustedMethod.prune().hasData()) parYieldCurveAdjustedMethod = null;
			if (zeroCouponYieldAdjustedMethod!=null && !zeroCouponYieldAdjustedMethod.prune().hasData()) zeroCouponYieldAdjustedMethod = null;
			if (parYieldCurveUnadjustedMethod!=null && !parYieldCurveUnadjustedMethod.prune().hasData()) parYieldCurveUnadjustedMethod = null;
			if (crossCurrencyMethod!=null && !crossCurrencyMethod.prune().hasData()) crossCurrencyMethod = null;
			if (collateralizedCashPriceMethod!=null && !collateralizedCashPriceMethod.prune().hasData()) collateralizedCashPriceMethod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashSettlementValuationTime()!=null && getCashSettlementValuationTime().hasData()) return true;
			if (getCashSettlementValuationDate()!=null && getCashSettlementValuationDate().hasData()) return true;
			if (getCashSettlementPaymentDate()!=null && getCashSettlementPaymentDate().hasData()) return true;
			if (getCashPriceMethod()!=null && getCashPriceMethod().hasData()) return true;
			if (getCashPriceAlternateMethod()!=null && getCashPriceAlternateMethod().hasData()) return true;
			if (getParYieldCurveAdjustedMethod()!=null && getParYieldCurveAdjustedMethod().hasData()) return true;
			if (getZeroCouponYieldAdjustedMethod()!=null && getZeroCouponYieldAdjustedMethod().hasData()) return true;
			if (getParYieldCurveUnadjustedMethod()!=null && getParYieldCurveUnadjustedMethod().hasData()) return true;
			if (getCrossCurrencyMethod()!=null && getCrossCurrencyMethod().hasData()) return true;
			if (getCollateralizedCashPriceMethod()!=null && getCollateralizedCashPriceMethod().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlement.CashSettlementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashSettlement.CashSettlementBuilder o = (CashSettlement.CashSettlementBuilder) other;
			
			merger.mergeRosetta(getCashSettlementValuationTime(), o.getCashSettlementValuationTime(), this::setCashSettlementValuationTime);
			merger.mergeRosetta(getCashSettlementValuationDate(), o.getCashSettlementValuationDate(), this::setCashSettlementValuationDate);
			merger.mergeRosetta(getCashSettlementPaymentDate(), o.getCashSettlementPaymentDate(), this::setCashSettlementPaymentDate);
			merger.mergeRosetta(getCashPriceMethod(), o.getCashPriceMethod(), this::setCashPriceMethod);
			merger.mergeRosetta(getCashPriceAlternateMethod(), o.getCashPriceAlternateMethod(), this::setCashPriceAlternateMethod);
			merger.mergeRosetta(getParYieldCurveAdjustedMethod(), o.getParYieldCurveAdjustedMethod(), this::setParYieldCurveAdjustedMethod);
			merger.mergeRosetta(getZeroCouponYieldAdjustedMethod(), o.getZeroCouponYieldAdjustedMethod(), this::setZeroCouponYieldAdjustedMethod);
			merger.mergeRosetta(getParYieldCurveUnadjustedMethod(), o.getParYieldCurveUnadjustedMethod(), this::setParYieldCurveUnadjustedMethod);
			merger.mergeRosetta(getCrossCurrencyMethod(), o.getCrossCurrencyMethod(), this::setCrossCurrencyMethod);
			merger.mergeRosetta(getCollateralizedCashPriceMethod(), o.getCollateralizedCashPriceMethod(), this::setCollateralizedCashPriceMethod);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlement _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementValuationTime, _that.getCashSettlementValuationTime())) return false;
			if (!Objects.equals(cashSettlementValuationDate, _that.getCashSettlementValuationDate())) return false;
			if (!Objects.equals(cashSettlementPaymentDate, _that.getCashSettlementPaymentDate())) return false;
			if (!Objects.equals(cashPriceMethod, _that.getCashPriceMethod())) return false;
			if (!Objects.equals(cashPriceAlternateMethod, _that.getCashPriceAlternateMethod())) return false;
			if (!Objects.equals(parYieldCurveAdjustedMethod, _that.getParYieldCurveAdjustedMethod())) return false;
			if (!Objects.equals(zeroCouponYieldAdjustedMethod, _that.getZeroCouponYieldAdjustedMethod())) return false;
			if (!Objects.equals(parYieldCurveUnadjustedMethod, _that.getParYieldCurveUnadjustedMethod())) return false;
			if (!Objects.equals(crossCurrencyMethod, _that.getCrossCurrencyMethod())) return false;
			if (!Objects.equals(collateralizedCashPriceMethod, _that.getCollateralizedCashPriceMethod())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementValuationTime != null ? cashSettlementValuationTime.hashCode() : 0);
			_result = 31 * _result + (cashSettlementValuationDate != null ? cashSettlementValuationDate.hashCode() : 0);
			_result = 31 * _result + (cashSettlementPaymentDate != null ? cashSettlementPaymentDate.hashCode() : 0);
			_result = 31 * _result + (cashPriceMethod != null ? cashPriceMethod.hashCode() : 0);
			_result = 31 * _result + (cashPriceAlternateMethod != null ? cashPriceAlternateMethod.hashCode() : 0);
			_result = 31 * _result + (parYieldCurveAdjustedMethod != null ? parYieldCurveAdjustedMethod.hashCode() : 0);
			_result = 31 * _result + (zeroCouponYieldAdjustedMethod != null ? zeroCouponYieldAdjustedMethod.hashCode() : 0);
			_result = 31 * _result + (parYieldCurveUnadjustedMethod != null ? parYieldCurveUnadjustedMethod.hashCode() : 0);
			_result = 31 * _result + (crossCurrencyMethod != null ? crossCurrencyMethod.hashCode() : 0);
			_result = 31 * _result + (collateralizedCashPriceMethod != null ? collateralizedCashPriceMethod.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementBuilder {" +
				"cashSettlementValuationTime=" + this.cashSettlementValuationTime + ", " +
				"cashSettlementValuationDate=" + this.cashSettlementValuationDate + ", " +
				"cashSettlementPaymentDate=" + this.cashSettlementPaymentDate + ", " +
				"cashPriceMethod=" + this.cashPriceMethod + ", " +
				"cashPriceAlternateMethod=" + this.cashPriceAlternateMethod + ", " +
				"parYieldCurveAdjustedMethod=" + this.parYieldCurveAdjustedMethod + ", " +
				"zeroCouponYieldAdjustedMethod=" + this.zeroCouponYieldAdjustedMethod + ", " +
				"parYieldCurveUnadjustedMethod=" + this.parYieldCurveUnadjustedMethod + ", " +
				"crossCurrencyMethod=" + this.crossCurrencyMethod + ", " +
				"collateralizedCashPriceMethod=" + this.collateralizedCashPriceMethod + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
