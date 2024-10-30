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
import fpml.confirmation.CommoditySpread;
import fpml.confirmation.CommoditySpread.CommoditySpreadBuilder;
import fpml.confirmation.CommoditySpread.CommoditySpreadBuilderImpl;
import fpml.confirmation.CommoditySpread.CommoditySpreadImpl;
import fpml.confirmation.Currency;
import fpml.confirmation.Money;
import fpml.confirmation.Money.MoneyBuilder;
import fpml.confirmation.Money.MoneyBuilderImpl;
import fpml.confirmation.Money.MoneyImpl;
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.meta.CommoditySpreadMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommoditySpread", builder=CommoditySpread.CommoditySpreadBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommoditySpread extends Money {

	CommoditySpreadMeta metaData = new CommoditySpreadMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * spreadConversionFactor should be used when the unit of measure of the Commodity Reference Price and the unit of measure in which the spread is quoted are different. The value of spreadConversionFactor is the number of units of measure in which the spread is quoted per unit of measure of the Commodity Reference Price.
	 */
	BigDecimal getSpreadConversionFactor();
	/**
	 * spreadUnit should be used when the unit of measure of the Commodity Reference Price and the unit of measure in which the spread is quoted are different. The value of spreadUnit is the unit of measure in which the spread is quoted.
	 */
	QuantityUnit getSpreadUnit();

	/*********************** Build Methods  ***********************/
	CommoditySpread build();
	
	CommoditySpread.CommoditySpreadBuilder toBuilder();
	
	static CommoditySpread.CommoditySpreadBuilder builder() {
		return new CommoditySpread.CommoditySpreadBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySpread> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommoditySpread> getType() {
		return CommoditySpread.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("spreadConversionFactor"), BigDecimal.class, getSpreadConversionFactor(), this);
		processRosetta(path.newSubPath("spreadUnit"), processor, QuantityUnit.class, getSpreadUnit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySpreadBuilder extends CommoditySpread, Money.MoneyBuilder {
		QuantityUnit.QuantityUnitBuilder getOrCreateSpreadUnit();
		QuantityUnit.QuantityUnitBuilder getSpreadUnit();
		CommoditySpread.CommoditySpreadBuilder setCurrency(Currency currency);
		CommoditySpread.CommoditySpreadBuilder setId(String id);
		CommoditySpread.CommoditySpreadBuilder setAmount(BigDecimal amount);
		CommoditySpread.CommoditySpreadBuilder setSpreadConversionFactor(BigDecimal spreadConversionFactor);
		CommoditySpread.CommoditySpreadBuilder setSpreadUnit(QuantityUnit spreadUnit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("spreadConversionFactor"), BigDecimal.class, getSpreadConversionFactor(), this);
			processRosetta(path.newSubPath("spreadUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getSpreadUnit());
		}
		

		CommoditySpread.CommoditySpreadBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySpread  ***********************/
	class CommoditySpreadImpl extends Money.MoneyImpl implements CommoditySpread {
		private final BigDecimal spreadConversionFactor;
		private final QuantityUnit spreadUnit;
		
		protected CommoditySpreadImpl(CommoditySpread.CommoditySpreadBuilder builder) {
			super(builder);
			this.spreadConversionFactor = builder.getSpreadConversionFactor();
			this.spreadUnit = ofNullable(builder.getSpreadUnit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("spreadConversionFactor")
		public BigDecimal getSpreadConversionFactor() {
			return spreadConversionFactor;
		}
		
		@Override
		@RosettaAttribute("spreadUnit")
		public QuantityUnit getSpreadUnit() {
			return spreadUnit;
		}
		
		@Override
		public CommoditySpread build() {
			return this;
		}
		
		@Override
		public CommoditySpread.CommoditySpreadBuilder toBuilder() {
			CommoditySpread.CommoditySpreadBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySpread.CommoditySpreadBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSpreadConversionFactor()).ifPresent(builder::setSpreadConversionFactor);
			ofNullable(getSpreadUnit()).ifPresent(builder::setSpreadUnit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommoditySpread _that = getType().cast(o);
		
			if (!Objects.equals(spreadConversionFactor, _that.getSpreadConversionFactor())) return false;
			if (!Objects.equals(spreadUnit, _that.getSpreadUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (spreadConversionFactor != null ? spreadConversionFactor.hashCode() : 0);
			_result = 31 * _result + (spreadUnit != null ? spreadUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySpread {" +
				"spreadConversionFactor=" + this.spreadConversionFactor + ", " +
				"spreadUnit=" + this.spreadUnit +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommoditySpread  ***********************/
	class CommoditySpreadBuilderImpl extends Money.MoneyBuilderImpl  implements CommoditySpread.CommoditySpreadBuilder {
	
		protected BigDecimal spreadConversionFactor;
		protected QuantityUnit.QuantityUnitBuilder spreadUnit;
	
		public CommoditySpreadBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("spreadConversionFactor")
		public BigDecimal getSpreadConversionFactor() {
			return spreadConversionFactor;
		}
		
		@Override
		@RosettaAttribute("spreadUnit")
		public QuantityUnit.QuantityUnitBuilder getSpreadUnit() {
			return spreadUnit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreateSpreadUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (spreadUnit!=null) {
				result = spreadUnit;
			}
			else {
				result = spreadUnit = QuantityUnit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency")
		public CommoditySpread.CommoditySpreadBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommoditySpread.CommoditySpreadBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public CommoditySpread.CommoditySpreadBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		@RosettaAttribute("spreadConversionFactor")
		public CommoditySpread.CommoditySpreadBuilder setSpreadConversionFactor(BigDecimal spreadConversionFactor) {
			this.spreadConversionFactor = spreadConversionFactor==null?null:spreadConversionFactor;
			return this;
		}
		@Override
		@RosettaAttribute("spreadUnit")
		public CommoditySpread.CommoditySpreadBuilder setSpreadUnit(QuantityUnit spreadUnit) {
			this.spreadUnit = spreadUnit==null?null:spreadUnit.toBuilder();
			return this;
		}
		
		@Override
		public CommoditySpread build() {
			return new CommoditySpread.CommoditySpreadImpl(this);
		}
		
		@Override
		public CommoditySpread.CommoditySpreadBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySpread.CommoditySpreadBuilder prune() {
			super.prune();
			if (spreadUnit!=null && !spreadUnit.prune().hasData()) spreadUnit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSpreadConversionFactor()!=null) return true;
			if (getSpreadUnit()!=null && getSpreadUnit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySpread.CommoditySpreadBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommoditySpread.CommoditySpreadBuilder o = (CommoditySpread.CommoditySpreadBuilder) other;
			
			merger.mergeRosetta(getSpreadUnit(), o.getSpreadUnit(), this::setSpreadUnit);
			
			merger.mergeBasic(getSpreadConversionFactor(), o.getSpreadConversionFactor(), this::setSpreadConversionFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommoditySpread _that = getType().cast(o);
		
			if (!Objects.equals(spreadConversionFactor, _that.getSpreadConversionFactor())) return false;
			if (!Objects.equals(spreadUnit, _that.getSpreadUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (spreadConversionFactor != null ? spreadConversionFactor.hashCode() : 0);
			_result = 31 * _result + (spreadUnit != null ? spreadUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommoditySpreadBuilder {" +
				"spreadConversionFactor=" + this.spreadConversionFactor + ", " +
				"spreadUnit=" + this.spreadUnit +
			'}' + " " + super.toString();
		}
	}
}
