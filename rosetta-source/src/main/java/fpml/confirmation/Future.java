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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.ExchangeIdentifierModel;
import fpml.confirmation.ExchangeTraded;
import fpml.confirmation.ExchangeTraded.ExchangeTradedBuilder;
import fpml.confirmation.ExchangeTraded.ExchangeTradedBuilderImpl;
import fpml.confirmation.ExchangeTraded.ExchangeTradedImpl;
import fpml.confirmation.ExchangeTradedContractUnderlyer;
import fpml.confirmation.Future;
import fpml.confirmation.Future.FutureBuilder;
import fpml.confirmation.Future.FutureBuilderImpl;
import fpml.confirmation.Future.FutureImpl;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.SettlementTypeEnum;
import fpml.confirmation.meta.FutureMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies the underlying asset when it is a listed future contract. An exchange traded future contract.
 * @version ${project.version}
 */
@RosettaDataType(value="Future", builder=Future.FutureBuilderImpl.class, version="${project.version}")
public interface Future extends ExchangeTraded {

	FutureMeta metaData = new FutureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The multiplier is the minimum number of the underlying - index or stock - that a participant has to trade while taking a position in the Future contract. The purpose of the multiplier is to inflate the value of the contract to add leverage to the trade. The multiplier for the Dow is 10, for the Nasdaq it is 100 and it is 250 for the Standard and Poor&#39;s index.
	 */
	BigDecimal getMultiplier();
	/**
	 * Native identifier for the contract on the listing exchange.
	 */
	String getFutureContractReference();
	/**
	 * The date when the future contract expires.
	 */
	Date getMaturity();
	/**
	 * The contract month of the futures contract. i.e. F13 WTI NYMEX Contract is 2013-01.
	 */
	Integer getContractYearMonth();
	/**
	 * Underlyer of the option e.g. a listed future.
	 */
	ExchangeTradedContractUnderlyer getUnderlyer();
	/**
	 * Settlement method for the contract (Cash, Physical). This value is used to populate the &quot;Delivery Type&quot; field for regulatory reporting (CFTC, ESMA).
	 */
	SettlementTypeEnum getSettlementType();

	/*********************** Build Methods  ***********************/
	Future build();
	
	Future.FutureBuilder toBuilder();
	
	static Future.FutureBuilder builder() {
		return new Future.FutureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Future> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Future> getType() {
		return Future.class;
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
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		processor.processBasic(path.newSubPath("futureContractReference"), String.class, getFutureContractReference(), this);
		processor.processBasic(path.newSubPath("maturity"), Date.class, getMaturity(), this);
		processor.processBasic(path.newSubPath("contractYearMonth"), Integer.class, getContractYearMonth(), this);
		processRosetta(path.newSubPath("underlyer"), processor, ExchangeTradedContractUnderlyer.class, getUnderlyer());
		processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FutureBuilder extends Future, ExchangeTraded.ExchangeTradedBuilder {
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getOrCreateUnderlyer();
		ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getUnderlyer();
		Future.FutureBuilder setId(String id);
		Future.FutureBuilder addInstrumentId(InstrumentId instrumentId0);
		Future.FutureBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		Future.FutureBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		Future.FutureBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		Future.FutureBuilder setDescription(String description);
		Future.FutureBuilder setCurrency(IdentifiedCurrency currency);
		Future.FutureBuilder setExchangeId(ExchangeId exchangeId);
		Future.FutureBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		Future.FutureBuilder setDefinition(ProductReference definition);
		Future.FutureBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel);
		Future.FutureBuilder setMultiplier(BigDecimal multiplier);
		Future.FutureBuilder setFutureContractReference(String futureContractReference);
		Future.FutureBuilder setMaturity(Date maturity);
		Future.FutureBuilder setContractYearMonth(Integer contractYearMonth);
		Future.FutureBuilder setUnderlyer(ExchangeTradedContractUnderlyer underlyer);
		Future.FutureBuilder setSettlementType(SettlementTypeEnum settlementType);

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
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
			processor.processBasic(path.newSubPath("futureContractReference"), String.class, getFutureContractReference(), this);
			processor.processBasic(path.newSubPath("maturity"), Date.class, getMaturity(), this);
			processor.processBasic(path.newSubPath("contractYearMonth"), Integer.class, getContractYearMonth(), this);
			processRosetta(path.newSubPath("underlyer"), processor, ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder.class, getUnderlyer());
			processor.processBasic(path.newSubPath("settlementType"), SettlementTypeEnum.class, getSettlementType(), this);
		}
		

		Future.FutureBuilder prune();
	}

	/*********************** Immutable Implementation of Future  ***********************/
	class FutureImpl extends ExchangeTraded.ExchangeTradedImpl implements Future {
		private final BigDecimal multiplier;
		private final String futureContractReference;
		private final Date maturity;
		private final Integer contractYearMonth;
		private final ExchangeTradedContractUnderlyer underlyer;
		private final SettlementTypeEnum settlementType;
		
		protected FutureImpl(Future.FutureBuilder builder) {
			super(builder);
			this.multiplier = builder.getMultiplier();
			this.futureContractReference = builder.getFutureContractReference();
			this.maturity = builder.getMaturity();
			this.contractYearMonth = builder.getContractYearMonth();
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
			this.settlementType = builder.getSettlementType();
		}
		
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("futureContractReference")
		public String getFutureContractReference() {
			return futureContractReference;
		}
		
		@Override
		@RosettaAttribute("maturity")
		public Date getMaturity() {
			return maturity;
		}
		
		@Override
		@RosettaAttribute("contractYearMonth")
		public Integer getContractYearMonth() {
			return contractYearMonth;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		public ExchangeTradedContractUnderlyer getUnderlyer() {
			return underlyer;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		public Future build() {
			return this;
		}
		
		@Override
		public Future.FutureBuilder toBuilder() {
			Future.FutureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Future.FutureBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
			ofNullable(getFutureContractReference()).ifPresent(builder::setFutureContractReference);
			ofNullable(getMaturity()).ifPresent(builder::setMaturity);
			ofNullable(getContractYearMonth()).ifPresent(builder::setContractYearMonth);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Future _that = getType().cast(o);
		
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(futureContractReference, _that.getFutureContractReference())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			if (!Objects.equals(contractYearMonth, _that.getContractYearMonth())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (futureContractReference != null ? futureContractReference.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			_result = 31 * _result + (contractYearMonth != null ? contractYearMonth.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Future {" +
				"multiplier=" + this.multiplier + ", " +
				"futureContractReference=" + this.futureContractReference + ", " +
				"maturity=" + this.maturity + ", " +
				"contractYearMonth=" + this.contractYearMonth + ", " +
				"underlyer=" + this.underlyer + ", " +
				"settlementType=" + this.settlementType +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Future  ***********************/
	class FutureBuilderImpl extends ExchangeTraded.ExchangeTradedBuilderImpl  implements Future.FutureBuilder {
	
		protected BigDecimal multiplier;
		protected String futureContractReference;
		protected Date maturity;
		protected Integer contractYearMonth;
		protected ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder underlyer;
		protected SettlementTypeEnum settlementType;
	
		public FutureBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("futureContractReference")
		public String getFutureContractReference() {
			return futureContractReference;
		}
		
		@Override
		@RosettaAttribute("maturity")
		public Date getMaturity() {
			return maturity;
		}
		
		@Override
		@RosettaAttribute("contractYearMonth")
		public Integer getContractYearMonth() {
			return contractYearMonth;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder getOrCreateUnderlyer() {
			ExchangeTradedContractUnderlyer.ExchangeTradedContractUnderlyerBuilder result;
			if (underlyer!=null) {
				result = underlyer;
			}
			else {
				result = underlyer = ExchangeTradedContractUnderlyer.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		public SettlementTypeEnum getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("id")
		public Future.FutureBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public Future.FutureBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Future.FutureBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public Future.FutureBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public Future.FutureBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Future.FutureBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public Future.FutureBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public Future.FutureBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public Future.FutureBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public Future.FutureBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public Future.FutureBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel) {
			this.exchangeIdentifierModel = exchangeIdentifierModel==null?null:exchangeIdentifierModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiplier")
		public Future.FutureBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		@Override
		@RosettaAttribute("futureContractReference")
		public Future.FutureBuilder setFutureContractReference(String futureContractReference) {
			this.futureContractReference = futureContractReference==null?null:futureContractReference;
			return this;
		}
		@Override
		@RosettaAttribute("maturity")
		public Future.FutureBuilder setMaturity(Date maturity) {
			this.maturity = maturity==null?null:maturity;
			return this;
		}
		@Override
		@RosettaAttribute("contractYearMonth")
		public Future.FutureBuilder setContractYearMonth(Integer contractYearMonth) {
			this.contractYearMonth = contractYearMonth==null?null:contractYearMonth;
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public Future.FutureBuilder setUnderlyer(ExchangeTradedContractUnderlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementType")
		public Future.FutureBuilder setSettlementType(SettlementTypeEnum settlementType) {
			this.settlementType = settlementType==null?null:settlementType;
			return this;
		}
		
		@Override
		public Future build() {
			return new Future.FutureImpl(this);
		}
		
		@Override
		public Future.FutureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Future.FutureBuilder prune() {
			super.prune();
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMultiplier()!=null) return true;
			if (getFutureContractReference()!=null) return true;
			if (getMaturity()!=null) return true;
			if (getContractYearMonth()!=null) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			if (getSettlementType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Future.FutureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Future.FutureBuilder o = (Future.FutureBuilder) other;
			
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			merger.mergeBasic(getFutureContractReference(), o.getFutureContractReference(), this::setFutureContractReference);
			merger.mergeBasic(getMaturity(), o.getMaturity(), this::setMaturity);
			merger.mergeBasic(getContractYearMonth(), o.getContractYearMonth(), this::setContractYearMonth);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Future _that = getType().cast(o);
		
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(futureContractReference, _that.getFutureContractReference())) return false;
			if (!Objects.equals(maturity, _that.getMaturity())) return false;
			if (!Objects.equals(contractYearMonth, _that.getContractYearMonth())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (futureContractReference != null ? futureContractReference.hashCode() : 0);
			_result = 31 * _result + (maturity != null ? maturity.hashCode() : 0);
			_result = 31 * _result + (contractYearMonth != null ? contractYearMonth.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FutureBuilder {" +
				"multiplier=" + this.multiplier + ", " +
				"futureContractReference=" + this.futureContractReference + ", " +
				"maturity=" + this.maturity + ", " +
				"contractYearMonth=" + this.contractYearMonth + ", " +
				"underlyer=" + this.underlyer + ", " +
				"settlementType=" + this.settlementType +
			'}' + " " + super.toString();
		}
	}
}
