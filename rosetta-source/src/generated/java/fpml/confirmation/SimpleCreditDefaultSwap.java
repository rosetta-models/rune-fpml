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
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.CreditEntityModel;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.Period;
import fpml.confirmation.ProductReference;
import fpml.confirmation.SimpleCreditDefaultSwap;
import fpml.confirmation.SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder;
import fpml.confirmation.SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilderImpl;
import fpml.confirmation.SimpleCreditDefaultSwap.SimpleCreditDefaultSwapImpl;
import fpml.confirmation.UnderlyingAssetType;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilder;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeImpl;
import fpml.confirmation.meta.SimpleCreditDefaultSwapMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies a simple underlying asset that is a credit default swap.
 * @version ${project.version}
 */
@RosettaDataType(value="SimpleCreditDefaultSwap", builder=SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilderImpl.class, version="${project.version}")
public interface SimpleCreditDefaultSwap extends UnderlyingAssetType {

	SimpleCreditDefaultSwapMeta metaData = new SimpleCreditDefaultSwapMeta();

	/*********************** Getter Methods  ***********************/
	CreditEntityModel getCreditEntityModel();
	/**
	 * Specifies the term of the simple CD swap, e.g. 5Y.
	 */
	Period getTerm();
	/**
	 * Specifies the frequency at which the swap pays, e.g. 6M.
	 */
	Period getPaymentFrequency();

	/*********************** Build Methods  ***********************/
	SimpleCreditDefaultSwap build();
	
	SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder toBuilder();
	
	static SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder builder() {
		return new SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SimpleCreditDefaultSwap> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SimpleCreditDefaultSwap> getType() {
		return SimpleCreditDefaultSwap.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
		processRosetta(path.newSubPath("creditEntityModel"), processor, CreditEntityModel.class, getCreditEntityModel());
		processRosetta(path.newSubPath("term"), processor, Period.class, getTerm());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SimpleCreditDefaultSwapBuilder extends SimpleCreditDefaultSwap, UnderlyingAssetType.UnderlyingAssetTypeBuilder {
		CreditEntityModel.CreditEntityModelBuilder getOrCreateCreditEntityModel();
		CreditEntityModel.CreditEntityModelBuilder getCreditEntityModel();
		Period.PeriodBuilder getOrCreateTerm();
		Period.PeriodBuilder getTerm();
		Period.PeriodBuilder getOrCreatePaymentFrequency();
		Period.PeriodBuilder getPaymentFrequency();
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setId(String id);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentId(InstrumentId instrumentId0);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setDescription(String description);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setCurrency(IdentifiedCurrency currency);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setExchangeId(ExchangeId exchangeId);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setDefinition(ProductReference definition);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setCreditEntityModel(CreditEntityModel creditEntityModel);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setTerm(Period term);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setPaymentFrequency(Period paymentFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("creditEntityModel"), processor, CreditEntityModel.CreditEntityModelBuilder.class, getCreditEntityModel());
			processRosetta(path.newSubPath("term"), processor, Period.PeriodBuilder.class, getTerm());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
		}
		

		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder prune();
	}

	/*********************** Immutable Implementation of SimpleCreditDefaultSwap  ***********************/
	class SimpleCreditDefaultSwapImpl extends UnderlyingAssetType.UnderlyingAssetTypeImpl implements SimpleCreditDefaultSwap {
		private final CreditEntityModel creditEntityModel;
		private final Period term;
		private final Period paymentFrequency;
		
		protected SimpleCreditDefaultSwapImpl(SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder builder) {
			super(builder);
			this.creditEntityModel = ofNullable(builder.getCreditEntityModel()).map(f->f.build()).orElse(null);
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditEntityModel")
		public CreditEntityModel getCreditEntityModel() {
			return creditEntityModel;
		}
		
		@Override
		@RosettaAttribute("term")
		public Period getTerm() {
			return term;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		public Period getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public SimpleCreditDefaultSwap build() {
			return this;
		}
		
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder toBuilder() {
			SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCreditEntityModel()).ifPresent(builder::setCreditEntityModel);
			ofNullable(getTerm()).ifPresent(builder::setTerm);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimpleCreditDefaultSwap _that = getType().cast(o);
		
			if (!Objects.equals(creditEntityModel, _that.getCreditEntityModel())) return false;
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (creditEntityModel != null ? creditEntityModel.hashCode() : 0);
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimpleCreditDefaultSwap {" +
				"creditEntityModel=" + this.creditEntityModel + ", " +
				"term=" + this.term + ", " +
				"paymentFrequency=" + this.paymentFrequency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SimpleCreditDefaultSwap  ***********************/
	class SimpleCreditDefaultSwapBuilderImpl extends UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl  implements SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder {
	
		protected CreditEntityModel.CreditEntityModelBuilder creditEntityModel;
		protected Period.PeriodBuilder term;
		protected Period.PeriodBuilder paymentFrequency;
	
		public SimpleCreditDefaultSwapBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("creditEntityModel")
		public CreditEntityModel.CreditEntityModelBuilder getCreditEntityModel() {
			return creditEntityModel;
		}
		
		@Override
		public CreditEntityModel.CreditEntityModelBuilder getOrCreateCreditEntityModel() {
			CreditEntityModel.CreditEntityModelBuilder result;
			if (creditEntityModel!=null) {
				result = creditEntityModel;
			}
			else {
				result = creditEntityModel = CreditEntityModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("term")
		public Period.PeriodBuilder getTerm() {
			return term;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTerm() {
			Period.PeriodBuilder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		public Period.PeriodBuilder getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreatePaymentFrequency() {
			Period.PeriodBuilder result;
			if (paymentFrequency!=null) {
				result = paymentFrequency;
			}
			else {
				result = paymentFrequency = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null)  {
				this.instrumentId = new ArrayList<>();
			}
			else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("description")
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditEntityModel")
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setCreditEntityModel(CreditEntityModel creditEntityModel) {
			this.creditEntityModel = creditEntityModel==null?null:creditEntityModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("term")
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setTerm(Period term) {
			this.term = term==null?null:term.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentFrequency")
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setPaymentFrequency(Period paymentFrequency) {
			this.paymentFrequency = paymentFrequency==null?null:paymentFrequency.toBuilder();
			return this;
		}
		
		@Override
		public SimpleCreditDefaultSwap build() {
			return new SimpleCreditDefaultSwap.SimpleCreditDefaultSwapImpl(this);
		}
		
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder prune() {
			super.prune();
			if (creditEntityModel!=null && !creditEntityModel.prune().hasData()) creditEntityModel = null;
			if (term!=null && !term.prune().hasData()) term = null;
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCreditEntityModel()!=null && getCreditEntityModel().hasData()) return true;
			if (getTerm()!=null && getTerm().hasData()) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder o = (SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder) other;
			
			merger.mergeRosetta(getCreditEntityModel(), o.getCreditEntityModel(), this::setCreditEntityModel);
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimpleCreditDefaultSwap _that = getType().cast(o);
		
			if (!Objects.equals(creditEntityModel, _that.getCreditEntityModel())) return false;
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (creditEntityModel != null ? creditEntityModel.hashCode() : 0);
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimpleCreditDefaultSwapBuilder {" +
				"creditEntityModel=" + this.creditEntityModel + ", " +
				"term=" + this.term + ", " +
				"paymentFrequency=" + this.paymentFrequency +
			'}' + " " + super.toString();
		}
	}
}
