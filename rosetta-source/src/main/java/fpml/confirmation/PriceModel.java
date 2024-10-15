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
import fpml.confirmation.Currency;
import fpml.confirmation.PriceModel;
import fpml.confirmation.PriceModel.PriceModelBuilder;
import fpml.confirmation.PriceModel.PriceModelBuilderImpl;
import fpml.confirmation.PriceModel.PriceModelImpl;
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.meta.PriceModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Price model group.
 * @version ${project.version}
 */
@RosettaDataType(value="PriceModel", builder=PriceModel.PriceModelBuilderImpl.class, version="${project.version}")
public interface PriceModel extends RosettaModelObject {

	PriceModelMeta metaData = new PriceModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency used to specify the digital barrier in terms of a price per unit of commodity.
	 */
	Currency getPriceCurrency();
	/**
	 * The unit of measure used to specify the digital barrier in terms of a price per unit of commodity.
	 */
	QuantityUnit getPriceUnit();

	/*********************** Build Methods  ***********************/
	PriceModel build();
	
	PriceModel.PriceModelBuilder toBuilder();
	
	static PriceModel.PriceModelBuilder builder() {
		return new PriceModel.PriceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PriceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PriceModel> getType() {
		return PriceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("priceCurrency"), processor, Currency.class, getPriceCurrency());
		processRosetta(path.newSubPath("priceUnit"), processor, QuantityUnit.class, getPriceUnit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PriceModelBuilder extends PriceModel, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreatePriceCurrency();
		Currency.CurrencyBuilder getPriceCurrency();
		QuantityUnit.QuantityUnitBuilder getOrCreatePriceUnit();
		QuantityUnit.QuantityUnitBuilder getPriceUnit();
		PriceModel.PriceModelBuilder setPriceCurrency(Currency priceCurrency);
		PriceModel.PriceModelBuilder setPriceUnit(QuantityUnit priceUnit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("priceCurrency"), processor, Currency.CurrencyBuilder.class, getPriceCurrency());
			processRosetta(path.newSubPath("priceUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getPriceUnit());
		}
		

		PriceModel.PriceModelBuilder prune();
	}

	/*********************** Immutable Implementation of PriceModel  ***********************/
	class PriceModelImpl implements PriceModel {
		private final Currency priceCurrency;
		private final QuantityUnit priceUnit;
		
		protected PriceModelImpl(PriceModel.PriceModelBuilder builder) {
			this.priceCurrency = ofNullable(builder.getPriceCurrency()).map(f->f.build()).orElse(null);
			this.priceUnit = ofNullable(builder.getPriceUnit()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("priceCurrency")
		public Currency getPriceCurrency() {
			return priceCurrency;
		}
		
		@Override
		@RosettaAttribute("priceUnit")
		public QuantityUnit getPriceUnit() {
			return priceUnit;
		}
		
		@Override
		public PriceModel build() {
			return this;
		}
		
		@Override
		public PriceModel.PriceModelBuilder toBuilder() {
			PriceModel.PriceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PriceModel.PriceModelBuilder builder) {
			ofNullable(getPriceCurrency()).ifPresent(builder::setPriceCurrency);
			ofNullable(getPriceUnit()).ifPresent(builder::setPriceUnit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceModel _that = getType().cast(o);
		
			if (!Objects.equals(priceCurrency, _that.getPriceCurrency())) return false;
			if (!Objects.equals(priceUnit, _that.getPriceUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (priceCurrency != null ? priceCurrency.hashCode() : 0);
			_result = 31 * _result + (priceUnit != null ? priceUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceModel {" +
				"priceCurrency=" + this.priceCurrency + ", " +
				"priceUnit=" + this.priceUnit +
			'}';
		}
	}

	/*********************** Builder Implementation of PriceModel  ***********************/
	class PriceModelBuilderImpl implements PriceModel.PriceModelBuilder {
	
		protected Currency.CurrencyBuilder priceCurrency;
		protected QuantityUnit.QuantityUnitBuilder priceUnit;
	
		public PriceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("priceCurrency")
		public Currency.CurrencyBuilder getPriceCurrency() {
			return priceCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreatePriceCurrency() {
			Currency.CurrencyBuilder result;
			if (priceCurrency!=null) {
				result = priceCurrency;
			}
			else {
				result = priceCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceUnit")
		public QuantityUnit.QuantityUnitBuilder getPriceUnit() {
			return priceUnit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreatePriceUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (priceUnit!=null) {
				result = priceUnit;
			}
			else {
				result = priceUnit = QuantityUnit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("priceCurrency")
		public PriceModel.PriceModelBuilder setPriceCurrency(Currency priceCurrency) {
			this.priceCurrency = priceCurrency==null?null:priceCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("priceUnit")
		public PriceModel.PriceModelBuilder setPriceUnit(QuantityUnit priceUnit) {
			this.priceUnit = priceUnit==null?null:priceUnit.toBuilder();
			return this;
		}
		
		@Override
		public PriceModel build() {
			return new PriceModel.PriceModelImpl(this);
		}
		
		@Override
		public PriceModel.PriceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceModel.PriceModelBuilder prune() {
			if (priceCurrency!=null && !priceCurrency.prune().hasData()) priceCurrency = null;
			if (priceUnit!=null && !priceUnit.prune().hasData()) priceUnit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPriceCurrency()!=null && getPriceCurrency().hasData()) return true;
			if (getPriceUnit()!=null && getPriceUnit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PriceModel.PriceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PriceModel.PriceModelBuilder o = (PriceModel.PriceModelBuilder) other;
			
			merger.mergeRosetta(getPriceCurrency(), o.getPriceCurrency(), this::setPriceCurrency);
			merger.mergeRosetta(getPriceUnit(), o.getPriceUnit(), this::setPriceUnit);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PriceModel _that = getType().cast(o);
		
			if (!Objects.equals(priceCurrency, _that.getPriceCurrency())) return false;
			if (!Objects.equals(priceUnit, _that.getPriceUnit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (priceCurrency != null ? priceCurrency.hashCode() : 0);
			_result = 31 * _result + (priceUnit != null ? priceUnit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PriceModelBuilder {" +
				"priceCurrency=" + this.priceCurrency + ", " +
				"priceUnit=" + this.priceUnit +
			'}';
		}
	}
}
