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
import fpml.confirmation.FxDisruptionFallback;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackBuilder;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackBuilderImpl;
import fpml.confirmation.FxDisruptionFallback.FxDisruptionFallbackImpl;
import fpml.confirmation.NonDeliverableSubstitute;
import fpml.confirmation.NonDeliverableSubstitute.NonDeliverableSubstituteBuilder;
import fpml.confirmation.NonDeliverableSubstitute.NonDeliverableSubstituteBuilderImpl;
import fpml.confirmation.NonDeliverableSubstitute.NonDeliverableSubstituteImpl;
import fpml.confirmation.meta.NonDeliverableSubstituteMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * If present indicates that the obligation to pay the In-the-Money amount of foreign currency is replaced with an obligation to pay an equivalent amount in another currency. Describes a currency which may be delivered instead
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="NonDeliverableSubstitute", builder=NonDeliverableSubstitute.NonDeliverableSubstituteBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface NonDeliverableSubstitute extends FxDisruptionFallback {

	NonDeliverableSubstituteMeta metaData = new NonDeliverableSubstituteMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The code for the currency which can be delivered if settlement in the original non-deliverable currency is not possible.
	 */
	Currency getCurrency();

	/*********************** Build Methods  ***********************/
	NonDeliverableSubstitute build();
	
	NonDeliverableSubstitute.NonDeliverableSubstituteBuilder toBuilder();
	
	static NonDeliverableSubstitute.NonDeliverableSubstituteBuilder builder() {
		return new NonDeliverableSubstitute.NonDeliverableSubstituteBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NonDeliverableSubstitute> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NonDeliverableSubstitute> getType() {
		return NonDeliverableSubstitute.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NonDeliverableSubstituteBuilder extends NonDeliverableSubstitute, FxDisruptionFallback.FxDisruptionFallbackBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder setCurrency(Currency currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		NonDeliverableSubstitute.NonDeliverableSubstituteBuilder prune();
	}

	/*********************** Immutable Implementation of NonDeliverableSubstitute  ***********************/
	class NonDeliverableSubstituteImpl extends FxDisruptionFallback.FxDisruptionFallbackImpl implements NonDeliverableSubstitute {
		private final Currency currency;
		
		protected NonDeliverableSubstituteImpl(NonDeliverableSubstitute.NonDeliverableSubstituteBuilder builder) {
			super(builder);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		public NonDeliverableSubstitute build() {
			return this;
		}
		
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder toBuilder() {
			NonDeliverableSubstitute.NonDeliverableSubstituteBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NonDeliverableSubstitute.NonDeliverableSubstituteBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonDeliverableSubstitute _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonDeliverableSubstitute {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of NonDeliverableSubstitute  ***********************/
	class NonDeliverableSubstituteBuilderImpl extends FxDisruptionFallback.FxDisruptionFallbackBuilderImpl  implements NonDeliverableSubstitute.NonDeliverableSubstituteBuilder {
	
		protected Currency.CurrencyBuilder currency;
	
		public NonDeliverableSubstituteBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency")
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public NonDeliverableSubstitute build() {
			return new NonDeliverableSubstitute.NonDeliverableSubstituteImpl(this);
		}
		
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder prune() {
			super.prune();
			if (currency!=null && !currency.prune().hasData()) currency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NonDeliverableSubstitute.NonDeliverableSubstituteBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			NonDeliverableSubstitute.NonDeliverableSubstituteBuilder o = (NonDeliverableSubstitute.NonDeliverableSubstituteBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			NonDeliverableSubstitute _that = getType().cast(o);
		
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NonDeliverableSubstituteBuilder {" +
				"currency=" + this.currency +
			'}' + " " + super.toString();
		}
	}
}
