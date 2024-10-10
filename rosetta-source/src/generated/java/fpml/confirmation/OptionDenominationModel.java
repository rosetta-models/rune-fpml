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
import fpml.confirmation.OptionDenominationModel;
import fpml.confirmation.OptionDenominationModel.OptionDenominationModelBuilder;
import fpml.confirmation.OptionDenominationModel.OptionDenominationModelBuilderImpl;
import fpml.confirmation.OptionDenominationModel.OptionDenominationModelImpl;
import fpml.confirmation.meta.OptionDenominationModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group containing the option denomination components.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionDenominationModel", builder=OptionDenominationModel.OptionDenominationModelBuilderImpl.class, version="${project.version}")
public interface OptionDenominationModel extends RosettaModelObject {

	OptionDenominationModelMeta metaData = new OptionDenominationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The number of units of underlyer per option comprised in the option transaction.
	 */
	BigDecimal getOptionEntitlement();
	/**
	 * TODO
	 */
	Currency getEntitlementCurrency();
	/**
	 * The number of options comprised in the option transaction.
	 */
	BigDecimal getNumberOfOptions();

	/*********************** Build Methods  ***********************/
	OptionDenominationModel build();
	
	OptionDenominationModel.OptionDenominationModelBuilder toBuilder();
	
	static OptionDenominationModel.OptionDenominationModelBuilder builder() {
		return new OptionDenominationModel.OptionDenominationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionDenominationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionDenominationModel> getType() {
		return OptionDenominationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
		processRosetta(path.newSubPath("entitlementCurrency"), processor, Currency.class, getEntitlementCurrency());
		processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionDenominationModelBuilder extends OptionDenominationModel, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateEntitlementCurrency();
		Currency.CurrencyBuilder getEntitlementCurrency();
		OptionDenominationModel.OptionDenominationModelBuilder setOptionEntitlement(BigDecimal optionEntitlement);
		OptionDenominationModel.OptionDenominationModelBuilder setEntitlementCurrency(Currency entitlementCurrency);
		OptionDenominationModel.OptionDenominationModelBuilder setNumberOfOptions(BigDecimal numberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("optionEntitlement"), BigDecimal.class, getOptionEntitlement(), this);
			processRosetta(path.newSubPath("entitlementCurrency"), processor, Currency.CurrencyBuilder.class, getEntitlementCurrency());
			processor.processBasic(path.newSubPath("numberOfOptions"), BigDecimal.class, getNumberOfOptions(), this);
		}
		

		OptionDenominationModel.OptionDenominationModelBuilder prune();
	}

	/*********************** Immutable Implementation of OptionDenominationModel  ***********************/
	class OptionDenominationModelImpl implements OptionDenominationModel {
		private final BigDecimal optionEntitlement;
		private final Currency entitlementCurrency;
		private final BigDecimal numberOfOptions;
		
		protected OptionDenominationModelImpl(OptionDenominationModel.OptionDenominationModelBuilder builder) {
			this.optionEntitlement = builder.getOptionEntitlement();
			this.entitlementCurrency = ofNullable(builder.getEntitlementCurrency()).map(f->f.build()).orElse(null);
			this.numberOfOptions = builder.getNumberOfOptions();
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("entitlementCurrency")
		public Currency getEntitlementCurrency() {
			return entitlementCurrency;
		}
		
		@Override
		@RosettaAttribute("numberOfOptions")
		public BigDecimal getNumberOfOptions() {
			return numberOfOptions;
		}
		
		@Override
		public OptionDenominationModel build() {
			return this;
		}
		
		@Override
		public OptionDenominationModel.OptionDenominationModelBuilder toBuilder() {
			OptionDenominationModel.OptionDenominationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionDenominationModel.OptionDenominationModelBuilder builder) {
			ofNullable(getOptionEntitlement()).ifPresent(builder::setOptionEntitlement);
			ofNullable(getEntitlementCurrency()).ifPresent(builder::setEntitlementCurrency);
			ofNullable(getNumberOfOptions()).ifPresent(builder::setNumberOfOptions);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionDenominationModel _that = getType().cast(o);
		
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(entitlementCurrency, _that.getEntitlementCurrency())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (entitlementCurrency != null ? entitlementCurrency.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionDenominationModel {" +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"entitlementCurrency=" + this.entitlementCurrency + ", " +
				"numberOfOptions=" + this.numberOfOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionDenominationModel  ***********************/
	class OptionDenominationModelBuilderImpl implements OptionDenominationModel.OptionDenominationModelBuilder {
	
		protected BigDecimal optionEntitlement;
		protected Currency.CurrencyBuilder entitlementCurrency;
		protected BigDecimal numberOfOptions;
	
		public OptionDenominationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionEntitlement")
		public BigDecimal getOptionEntitlement() {
			return optionEntitlement;
		}
		
		@Override
		@RosettaAttribute("entitlementCurrency")
		public Currency.CurrencyBuilder getEntitlementCurrency() {
			return entitlementCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateEntitlementCurrency() {
			Currency.CurrencyBuilder result;
			if (entitlementCurrency!=null) {
				result = entitlementCurrency;
			}
			else {
				result = entitlementCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfOptions")
		public BigDecimal getNumberOfOptions() {
			return numberOfOptions;
		}
		
		@Override
		@RosettaAttribute("optionEntitlement")
		public OptionDenominationModel.OptionDenominationModelBuilder setOptionEntitlement(BigDecimal optionEntitlement) {
			this.optionEntitlement = optionEntitlement==null?null:optionEntitlement;
			return this;
		}
		@Override
		@RosettaAttribute("entitlementCurrency")
		public OptionDenominationModel.OptionDenominationModelBuilder setEntitlementCurrency(Currency entitlementCurrency) {
			this.entitlementCurrency = entitlementCurrency==null?null:entitlementCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("numberOfOptions")
		public OptionDenominationModel.OptionDenominationModelBuilder setNumberOfOptions(BigDecimal numberOfOptions) {
			this.numberOfOptions = numberOfOptions==null?null:numberOfOptions;
			return this;
		}
		
		@Override
		public OptionDenominationModel build() {
			return new OptionDenominationModel.OptionDenominationModelImpl(this);
		}
		
		@Override
		public OptionDenominationModel.OptionDenominationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionDenominationModel.OptionDenominationModelBuilder prune() {
			if (entitlementCurrency!=null && !entitlementCurrency.prune().hasData()) entitlementCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOptionEntitlement()!=null) return true;
			if (getEntitlementCurrency()!=null && getEntitlementCurrency().hasData()) return true;
			if (getNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionDenominationModel.OptionDenominationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionDenominationModel.OptionDenominationModelBuilder o = (OptionDenominationModel.OptionDenominationModelBuilder) other;
			
			merger.mergeRosetta(getEntitlementCurrency(), o.getEntitlementCurrency(), this::setEntitlementCurrency);
			
			merger.mergeBasic(getOptionEntitlement(), o.getOptionEntitlement(), this::setOptionEntitlement);
			merger.mergeBasic(getNumberOfOptions(), o.getNumberOfOptions(), this::setNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionDenominationModel _that = getType().cast(o);
		
			if (!Objects.equals(optionEntitlement, _that.getOptionEntitlement())) return false;
			if (!Objects.equals(entitlementCurrency, _that.getEntitlementCurrency())) return false;
			if (!Objects.equals(numberOfOptions, _that.getNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionEntitlement != null ? optionEntitlement.hashCode() : 0);
			_result = 31 * _result + (entitlementCurrency != null ? entitlementCurrency.hashCode() : 0);
			_result = 31 * _result + (numberOfOptions != null ? numberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionDenominationModelBuilder {" +
				"optionEntitlement=" + this.optionEntitlement + ", " +
				"entitlementCurrency=" + this.entitlementCurrency + ", " +
				"numberOfOptions=" + this.numberOfOptions +
			'}';
		}
	}
}
