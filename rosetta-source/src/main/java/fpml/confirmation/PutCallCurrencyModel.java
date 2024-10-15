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
import fpml.confirmation.PutCallCurrencyModel;
import fpml.confirmation.PutCallCurrencyModel.PutCallCurrencyModelBuilder;
import fpml.confirmation.PutCallCurrencyModel.PutCallCurrencyModelBuilderImpl;
import fpml.confirmation.PutCallCurrencyModel.PutCallCurrencyModelImpl;
import fpml.confirmation.meta.PutCallCurrencyModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PutCallCurrencyModel", builder=PutCallCurrencyModel.PutCallCurrencyModelBuilderImpl.class, version="${project.version}")
public interface PutCallCurrencyModel extends RosettaModelObject {

	PutCallCurrencyModelMeta metaData = new PutCallCurrencyModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The currency which: - the option buyer will pay (sell) - the option writer will receive (buy)
	 */
	Currency getPutCurrency();
	/**
	 * The currency which: - the option buyer will receive (buy) - the option writer will pay (sell)
	 */
	Currency getCallCurrency();

	/*********************** Build Methods  ***********************/
	PutCallCurrencyModel build();
	
	PutCallCurrencyModel.PutCallCurrencyModelBuilder toBuilder();
	
	static PutCallCurrencyModel.PutCallCurrencyModelBuilder builder() {
		return new PutCallCurrencyModel.PutCallCurrencyModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PutCallCurrencyModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PutCallCurrencyModel> getType() {
		return PutCallCurrencyModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("putCurrency"), processor, Currency.class, getPutCurrency());
		processRosetta(path.newSubPath("callCurrency"), processor, Currency.class, getCallCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PutCallCurrencyModelBuilder extends PutCallCurrencyModel, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreatePutCurrency();
		Currency.CurrencyBuilder getPutCurrency();
		Currency.CurrencyBuilder getOrCreateCallCurrency();
		Currency.CurrencyBuilder getCallCurrency();
		PutCallCurrencyModel.PutCallCurrencyModelBuilder setPutCurrency(Currency putCurrency);
		PutCallCurrencyModel.PutCallCurrencyModelBuilder setCallCurrency(Currency callCurrency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("putCurrency"), processor, Currency.CurrencyBuilder.class, getPutCurrency());
			processRosetta(path.newSubPath("callCurrency"), processor, Currency.CurrencyBuilder.class, getCallCurrency());
		}
		

		PutCallCurrencyModel.PutCallCurrencyModelBuilder prune();
	}

	/*********************** Immutable Implementation of PutCallCurrencyModel  ***********************/
	class PutCallCurrencyModelImpl implements PutCallCurrencyModel {
		private final Currency putCurrency;
		private final Currency callCurrency;
		
		protected PutCallCurrencyModelImpl(PutCallCurrencyModel.PutCallCurrencyModelBuilder builder) {
			this.putCurrency = ofNullable(builder.getPutCurrency()).map(f->f.build()).orElse(null);
			this.callCurrency = ofNullable(builder.getCallCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("putCurrency")
		public Currency getPutCurrency() {
			return putCurrency;
		}
		
		@Override
		@RosettaAttribute("callCurrency")
		public Currency getCallCurrency() {
			return callCurrency;
		}
		
		@Override
		public PutCallCurrencyModel build() {
			return this;
		}
		
		@Override
		public PutCallCurrencyModel.PutCallCurrencyModelBuilder toBuilder() {
			PutCallCurrencyModel.PutCallCurrencyModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PutCallCurrencyModel.PutCallCurrencyModelBuilder builder) {
			ofNullable(getPutCurrency()).ifPresent(builder::setPutCurrency);
			ofNullable(getCallCurrency()).ifPresent(builder::setCallCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PutCallCurrencyModel _that = getType().cast(o);
		
			if (!Objects.equals(putCurrency, _that.getPutCurrency())) return false;
			if (!Objects.equals(callCurrency, _that.getCallCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (putCurrency != null ? putCurrency.hashCode() : 0);
			_result = 31 * _result + (callCurrency != null ? callCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PutCallCurrencyModel {" +
				"putCurrency=" + this.putCurrency + ", " +
				"callCurrency=" + this.callCurrency +
			'}';
		}
	}

	/*********************** Builder Implementation of PutCallCurrencyModel  ***********************/
	class PutCallCurrencyModelBuilderImpl implements PutCallCurrencyModel.PutCallCurrencyModelBuilder {
	
		protected Currency.CurrencyBuilder putCurrency;
		protected Currency.CurrencyBuilder callCurrency;
	
		public PutCallCurrencyModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("putCurrency")
		public Currency.CurrencyBuilder getPutCurrency() {
			return putCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreatePutCurrency() {
			Currency.CurrencyBuilder result;
			if (putCurrency!=null) {
				result = putCurrency;
			}
			else {
				result = putCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("callCurrency")
		public Currency.CurrencyBuilder getCallCurrency() {
			return callCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCallCurrency() {
			Currency.CurrencyBuilder result;
			if (callCurrency!=null) {
				result = callCurrency;
			}
			else {
				result = callCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("putCurrency")
		public PutCallCurrencyModel.PutCallCurrencyModelBuilder setPutCurrency(Currency putCurrency) {
			this.putCurrency = putCurrency==null?null:putCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("callCurrency")
		public PutCallCurrencyModel.PutCallCurrencyModelBuilder setCallCurrency(Currency callCurrency) {
			this.callCurrency = callCurrency==null?null:callCurrency.toBuilder();
			return this;
		}
		
		@Override
		public PutCallCurrencyModel build() {
			return new PutCallCurrencyModel.PutCallCurrencyModelImpl(this);
		}
		
		@Override
		public PutCallCurrencyModel.PutCallCurrencyModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PutCallCurrencyModel.PutCallCurrencyModelBuilder prune() {
			if (putCurrency!=null && !putCurrency.prune().hasData()) putCurrency = null;
			if (callCurrency!=null && !callCurrency.prune().hasData()) callCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPutCurrency()!=null && getPutCurrency().hasData()) return true;
			if (getCallCurrency()!=null && getCallCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PutCallCurrencyModel.PutCallCurrencyModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PutCallCurrencyModel.PutCallCurrencyModelBuilder o = (PutCallCurrencyModel.PutCallCurrencyModelBuilder) other;
			
			merger.mergeRosetta(getPutCurrency(), o.getPutCurrency(), this::setPutCurrency);
			merger.mergeRosetta(getCallCurrency(), o.getCallCurrency(), this::setCallCurrency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PutCallCurrencyModel _that = getType().cast(o);
		
			if (!Objects.equals(putCurrency, _that.getPutCurrency())) return false;
			if (!Objects.equals(callCurrency, _that.getCallCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (putCurrency != null ? putCurrency.hashCode() : 0);
			_result = 31 * _result + (callCurrency != null ? callCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PutCallCurrencyModelBuilder {" +
				"putCurrency=" + this.putCurrency + ", " +
				"callCurrency=" + this.callCurrency +
			'}';
		}
	}
}
