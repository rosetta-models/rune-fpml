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
import fpml.confirmation.CurrencyAndDeterminationMethodModel;
import fpml.confirmation.CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder;
import fpml.confirmation.CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilderImpl;
import fpml.confirmation.CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelImpl;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.IdentifiedCurrencyReference;
import fpml.confirmation.meta.CurrencyAndDeterminationMethodModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group containing return swap amount currency definition methods
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CurrencyAndDeterminationMethodModel", builder=CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CurrencyAndDeterminationMethodModel extends RosettaModelObject {

	CurrencyAndDeterminationMethodModelMeta metaData = new CurrencyAndDeterminationMethodModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency in which an amount is denominated.
	 */
	IdentifiedCurrency getCurrency();
	/**
	 * Specifies the method according to which an amount or a date is determined.
	 */
	DeterminationMethod getDeterminationMethod();
	/**
	 * Reference to a currency defined elsewhere in the document
	 */
	IdentifiedCurrencyReference getCurrencyReference();

	/*********************** Build Methods  ***********************/
	CurrencyAndDeterminationMethodModel build();
	
	CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder toBuilder();
	
	static CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder builder() {
		return new CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CurrencyAndDeterminationMethodModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CurrencyAndDeterminationMethodModel> getType() {
		return CurrencyAndDeterminationMethodModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.class, getDeterminationMethod());
		processRosetta(path.newSubPath("currencyReference"), processor, IdentifiedCurrencyReference.class, getCurrencyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CurrencyAndDeterminationMethodModelBuilder extends CurrencyAndDeterminationMethodModel, RosettaModelObjectBuilder {
		IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateCurrency();
		IdentifiedCurrency.IdentifiedCurrencyBuilder getCurrency();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod();
		DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod();
		IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder getOrCreateCurrencyReference();
		IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder getCurrencyReference();
		CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder setCurrency(IdentifiedCurrency currency);
		CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder setDeterminationMethod(DeterminationMethod determinationMethod);
		CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder setCurrencyReference(IdentifiedCurrencyReference currencyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("determinationMethod"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getDeterminationMethod());
			processRosetta(path.newSubPath("currencyReference"), processor, IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder.class, getCurrencyReference());
		}
		

		CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder prune();
	}

	/*********************** Immutable Implementation of CurrencyAndDeterminationMethodModel  ***********************/
	class CurrencyAndDeterminationMethodModelImpl implements CurrencyAndDeterminationMethodModel {
		private final IdentifiedCurrency currency;
		private final DeterminationMethod determinationMethod;
		private final IdentifiedCurrencyReference currencyReference;
		
		protected CurrencyAndDeterminationMethodModelImpl(CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder builder) {
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.determinationMethod = ofNullable(builder.getDeterminationMethod()).map(f->f.build()).orElse(null);
			this.currencyReference = ofNullable(builder.getCurrencyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		public IdentifiedCurrency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		public DeterminationMethod getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		@RosettaAttribute("currencyReference")
		public IdentifiedCurrencyReference getCurrencyReference() {
			return currencyReference;
		}
		
		@Override
		public CurrencyAndDeterminationMethodModel build() {
			return this;
		}
		
		@Override
		public CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder toBuilder() {
			CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder builder) {
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getDeterminationMethod()).ifPresent(builder::setDeterminationMethod);
			ofNullable(getCurrencyReference()).ifPresent(builder::setCurrencyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CurrencyAndDeterminationMethodModel _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(currencyReference, _that.getCurrencyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (currencyReference != null ? currencyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurrencyAndDeterminationMethodModel {" +
				"currency=" + this.currency + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"currencyReference=" + this.currencyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of CurrencyAndDeterminationMethodModel  ***********************/
	class CurrencyAndDeterminationMethodModelBuilderImpl implements CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder {
	
		protected IdentifiedCurrency.IdentifiedCurrencyBuilder currency;
		protected DeterminationMethod.DeterminationMethodBuilder determinationMethod;
		protected IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder currencyReference;
	
		public CurrencyAndDeterminationMethodModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currency")
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public IdentifiedCurrency.IdentifiedCurrencyBuilder getOrCreateCurrency() {
			IdentifiedCurrency.IdentifiedCurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = IdentifiedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("determinationMethod")
		public DeterminationMethod.DeterminationMethodBuilder getDeterminationMethod() {
			return determinationMethod;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateDeterminationMethod() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (determinationMethod!=null) {
				result = determinationMethod;
			}
			else {
				result = determinationMethod = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currencyReference")
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder getCurrencyReference() {
			return currencyReference;
		}
		
		@Override
		public IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder getOrCreateCurrencyReference() {
			IdentifiedCurrencyReference.IdentifiedCurrencyReferenceBuilder result;
			if (currencyReference!=null) {
				result = currencyReference;
			}
			else {
				result = currencyReference = IdentifiedCurrencyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency")
		public CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("determinationMethod")
		public CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder setDeterminationMethod(DeterminationMethod determinationMethod) {
			this.determinationMethod = determinationMethod==null?null:determinationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currencyReference")
		public CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder setCurrencyReference(IdentifiedCurrencyReference currencyReference) {
			this.currencyReference = currencyReference==null?null:currencyReference.toBuilder();
			return this;
		}
		
		@Override
		public CurrencyAndDeterminationMethodModel build() {
			return new CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelImpl(this);
		}
		
		@Override
		public CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (determinationMethod!=null && !determinationMethod.prune().hasData()) determinationMethod = null;
			if (currencyReference!=null && !currencyReference.prune().hasData()) currencyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getDeterminationMethod()!=null && getDeterminationMethod().hasData()) return true;
			if (getCurrencyReference()!=null && getCurrencyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder o = (CurrencyAndDeterminationMethodModel.CurrencyAndDeterminationMethodModelBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getDeterminationMethod(), o.getDeterminationMethod(), this::setDeterminationMethod);
			merger.mergeRosetta(getCurrencyReference(), o.getCurrencyReference(), this::setCurrencyReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CurrencyAndDeterminationMethodModel _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(determinationMethod, _that.getDeterminationMethod())) return false;
			if (!Objects.equals(currencyReference, _that.getCurrencyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (determinationMethod != null ? determinationMethod.hashCode() : 0);
			_result = 31 * _result + (currencyReference != null ? currencyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurrencyAndDeterminationMethodModelBuilder {" +
				"currency=" + this.currency + ", " +
				"determinationMethod=" + this.determinationMethod + ", " +
				"currencyReference=" + this.currencyReference +
			'}';
		}
	}
}
