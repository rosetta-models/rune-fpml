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
import fpml.confirmation.ExchangeId;
import fpml.confirmation.ExchangeIdentifierModel;
import fpml.confirmation.ExchangeTradedCalculatedPrice;
import fpml.confirmation.ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder;
import fpml.confirmation.ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilderImpl;
import fpml.confirmation.ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceImpl;
import fpml.confirmation.ExchangeTradedFund;
import fpml.confirmation.ExchangeTradedFund.ExchangeTradedFundBuilder;
import fpml.confirmation.ExchangeTradedFund.ExchangeTradedFundBuilderImpl;
import fpml.confirmation.ExchangeTradedFund.ExchangeTradedFundImpl;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.meta.ExchangeTradedFundMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies the underlying asset when it is an exchange-traded fund. An exchange traded fund whose price depends on exchange traded constituents.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ExchangeTradedFund", builder=ExchangeTradedFund.ExchangeTradedFundBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ExchangeTradedFund extends ExchangeTradedCalculatedPrice {

	ExchangeTradedFundMeta metaData = new ExchangeTradedFundMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the fund manager that is in charge of the fund.
	 */
	String getFundManager();

	/*********************** Build Methods  ***********************/
	ExchangeTradedFund build();
	
	ExchangeTradedFund.ExchangeTradedFundBuilder toBuilder();
	
	static ExchangeTradedFund.ExchangeTradedFundBuilder builder() {
		return new ExchangeTradedFund.ExchangeTradedFundBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTradedFund> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExchangeTradedFund> getType() {
		return ExchangeTradedFund.class;
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
		processRosetta(path.newSubPath("exchangeIdentifierModel"), processor, ExchangeIdentifierModel.class, getExchangeIdentifierModel());
		processRosetta(path.newSubPath("constituentExchangeId"), processor, ExchangeId.class, getConstituentExchangeId());
		processor.processBasic(path.newSubPath("fundManager"), String.class, getFundManager(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeTradedFundBuilder extends ExchangeTradedFund, ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder {
		ExchangeTradedFund.ExchangeTradedFundBuilder setId(String id);
		ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentId(InstrumentId instrumentId0);
		ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		ExchangeTradedFund.ExchangeTradedFundBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		ExchangeTradedFund.ExchangeTradedFundBuilder setDescription(String description);
		ExchangeTradedFund.ExchangeTradedFundBuilder setCurrency(IdentifiedCurrency currency);
		ExchangeTradedFund.ExchangeTradedFundBuilder setExchangeId(ExchangeId exchangeId);
		ExchangeTradedFund.ExchangeTradedFundBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		ExchangeTradedFund.ExchangeTradedFundBuilder setDefinition(ProductReference definition);
		ExchangeTradedFund.ExchangeTradedFundBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel);
		ExchangeTradedFund.ExchangeTradedFundBuilder addConstituentExchangeId(ExchangeId constituentExchangeId0);
		ExchangeTradedFund.ExchangeTradedFundBuilder addConstituentExchangeId(ExchangeId constituentExchangeId1, int _idx);
		ExchangeTradedFund.ExchangeTradedFundBuilder addConstituentExchangeId(List<? extends ExchangeId> constituentExchangeId2);
		ExchangeTradedFund.ExchangeTradedFundBuilder setConstituentExchangeId(List<? extends ExchangeId> constituentExchangeId3);
		ExchangeTradedFund.ExchangeTradedFundBuilder setFundManager(String fundManager);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("exchangeIdentifierModel"), processor, ExchangeIdentifierModel.ExchangeIdentifierModelBuilder.class, getExchangeIdentifierModel());
			processRosetta(path.newSubPath("constituentExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getConstituentExchangeId());
			processor.processBasic(path.newSubPath("fundManager"), String.class, getFundManager(), this);
		}
		

		ExchangeTradedFund.ExchangeTradedFundBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTradedFund  ***********************/
	class ExchangeTradedFundImpl extends ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceImpl implements ExchangeTradedFund {
		private final String fundManager;
		
		protected ExchangeTradedFundImpl(ExchangeTradedFund.ExchangeTradedFundBuilder builder) {
			super(builder);
			this.fundManager = builder.getFundManager();
		}
		
		@Override
		@RosettaAttribute("fundManager")
		public String getFundManager() {
			return fundManager;
		}
		
		@Override
		public ExchangeTradedFund build() {
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder toBuilder() {
			ExchangeTradedFund.ExchangeTradedFundBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTradedFund.ExchangeTradedFundBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFundManager()).ifPresent(builder::setFundManager);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedFund _that = getType().cast(o);
		
			if (!Objects.equals(fundManager, _that.getFundManager())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fundManager != null ? fundManager.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedFund {" +
				"fundManager=" + this.fundManager +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExchangeTradedFund  ***********************/
	class ExchangeTradedFundBuilderImpl extends ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilderImpl  implements ExchangeTradedFund.ExchangeTradedFundBuilder {
	
		protected String fundManager;
	
		public ExchangeTradedFundBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fundManager")
		public String getFundManager() {
			return fundManager;
		}
		
		@Override
		@RosettaAttribute("id")
		public ExchangeTradedFund.ExchangeTradedFundBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExchangeTradedFund.ExchangeTradedFundBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTradedFund.ExchangeTradedFundBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public ExchangeTradedFund.ExchangeTradedFundBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public ExchangeTradedFund.ExchangeTradedFundBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public ExchangeTradedFund.ExchangeTradedFundBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public ExchangeTradedFund.ExchangeTradedFundBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public ExchangeTradedFund.ExchangeTradedFundBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel) {
			this.exchangeIdentifierModel = exchangeIdentifierModel==null?null:exchangeIdentifierModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("constituentExchangeId")
		public ExchangeTradedFund.ExchangeTradedFundBuilder addConstituentExchangeId(ExchangeId constituentExchangeId) {
			if (constituentExchangeId!=null) this.constituentExchangeId.add(constituentExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addConstituentExchangeId(ExchangeId constituentExchangeId, int _idx) {
			getIndex(this.constituentExchangeId, _idx, () -> constituentExchangeId.toBuilder());
			return this;
		}
		@Override 
		public ExchangeTradedFund.ExchangeTradedFundBuilder addConstituentExchangeId(List<? extends ExchangeId> constituentExchangeIds) {
			if (constituentExchangeIds != null) {
				for (ExchangeId toAdd : constituentExchangeIds) {
					this.constituentExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExchangeTradedFund.ExchangeTradedFundBuilder setConstituentExchangeId(List<? extends ExchangeId> constituentExchangeIds) {
			if (constituentExchangeIds == null)  {
				this.constituentExchangeId = new ArrayList<>();
			}
			else {
				this.constituentExchangeId = constituentExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("fundManager")
		public ExchangeTradedFund.ExchangeTradedFundBuilder setFundManager(String fundManager) {
			this.fundManager = fundManager==null?null:fundManager;
			return this;
		}
		
		@Override
		public ExchangeTradedFund build() {
			return new ExchangeTradedFund.ExchangeTradedFundImpl(this);
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFundManager()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExchangeTradedFund.ExchangeTradedFundBuilder o = (ExchangeTradedFund.ExchangeTradedFundBuilder) other;
			
			
			merger.mergeBasic(getFundManager(), o.getFundManager(), this::setFundManager);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedFund _that = getType().cast(o);
		
			if (!Objects.equals(fundManager, _that.getFundManager())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fundManager != null ? fundManager.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedFundBuilder {" +
				"fundManager=" + this.fundManager +
			'}' + " " + super.toString();
		}
	}
}
