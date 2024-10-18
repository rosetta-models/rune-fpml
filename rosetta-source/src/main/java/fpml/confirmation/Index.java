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
import fpml.confirmation.FutureId;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.Index;
import fpml.confirmation.Index.IndexBuilder;
import fpml.confirmation.Index.IndexBuilderImpl;
import fpml.confirmation.Index.IndexImpl;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.meta.IndexMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies the underlying asset when it is a financial index. A published index whose price depends on exchange traded constituents.
 * @version ${project.version}
 */
@RosettaDataType(value="Index", builder=Index.IndexBuilderImpl.class, version="${project.version}")
public interface Index extends ExchangeTradedCalculatedPrice {

	IndexMeta metaData = new IndexMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A short form unique identifier for the reference future contract in the case of an index underlyer.
	 */
	FutureId getFutureId();

	/*********************** Build Methods  ***********************/
	Index build();
	
	Index.IndexBuilder toBuilder();
	
	static Index.IndexBuilder builder() {
		return new Index.IndexBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Index> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Index> getType() {
		return Index.class;
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
		processRosetta(path.newSubPath("futureId"), processor, FutureId.class, getFutureId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexBuilder extends Index, ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder {
		FutureId.FutureIdBuilder getOrCreateFutureId();
		FutureId.FutureIdBuilder getFutureId();
		Index.IndexBuilder setId(String id);
		Index.IndexBuilder addInstrumentId(InstrumentId instrumentId0);
		Index.IndexBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		Index.IndexBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		Index.IndexBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		Index.IndexBuilder setDescription(String description);
		Index.IndexBuilder setCurrency(IdentifiedCurrency currency);
		Index.IndexBuilder setExchangeId(ExchangeId exchangeId);
		Index.IndexBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		Index.IndexBuilder setDefinition(ProductReference definition);
		Index.IndexBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel);
		Index.IndexBuilder addConstituentExchangeId(ExchangeId constituentExchangeId0);
		Index.IndexBuilder addConstituentExchangeId(ExchangeId constituentExchangeId1, int _idx);
		Index.IndexBuilder addConstituentExchangeId(List<? extends ExchangeId> constituentExchangeId2);
		Index.IndexBuilder setConstituentExchangeId(List<? extends ExchangeId> constituentExchangeId3);
		Index.IndexBuilder setFutureId(FutureId futureId);

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
			processRosetta(path.newSubPath("futureId"), processor, FutureId.FutureIdBuilder.class, getFutureId());
		}
		

		Index.IndexBuilder prune();
	}

	/*********************** Immutable Implementation of Index  ***********************/
	class IndexImpl extends ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceImpl implements Index {
		private final FutureId futureId;
		
		protected IndexImpl(Index.IndexBuilder builder) {
			super(builder);
			this.futureId = ofNullable(builder.getFutureId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("futureId")
		public FutureId getFutureId() {
			return futureId;
		}
		
		@Override
		public Index build() {
			return this;
		}
		
		@Override
		public Index.IndexBuilder toBuilder() {
			Index.IndexBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Index.IndexBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFutureId()).ifPresent(builder::setFutureId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Index _that = getType().cast(o);
		
			if (!Objects.equals(futureId, _that.getFutureId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (futureId != null ? futureId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Index {" +
				"futureId=" + this.futureId +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Index  ***********************/
	class IndexBuilderImpl extends ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilderImpl  implements Index.IndexBuilder {
	
		protected FutureId.FutureIdBuilder futureId;
	
		public IndexBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("futureId")
		public FutureId.FutureIdBuilder getFutureId() {
			return futureId;
		}
		
		@Override
		public FutureId.FutureIdBuilder getOrCreateFutureId() {
			FutureId.FutureIdBuilder result;
			if (futureId!=null) {
				result = futureId;
			}
			else {
				result = futureId = FutureId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public Index.IndexBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public Index.IndexBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Index.IndexBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public Index.IndexBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Index.IndexBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Index.IndexBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public Index.IndexBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public Index.IndexBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public Index.IndexBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public Index.IndexBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public Index.IndexBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel) {
			this.exchangeIdentifierModel = exchangeIdentifierModel==null?null:exchangeIdentifierModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("constituentExchangeId")
		public Index.IndexBuilder addConstituentExchangeId(ExchangeId constituentExchangeId) {
			if (constituentExchangeId!=null) this.constituentExchangeId.add(constituentExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public Index.IndexBuilder addConstituentExchangeId(ExchangeId constituentExchangeId, int _idx) {
			getIndex(this.constituentExchangeId, _idx, () -> constituentExchangeId.toBuilder());
			return this;
		}
		@Override 
		public Index.IndexBuilder addConstituentExchangeId(List<? extends ExchangeId> constituentExchangeIds) {
			if (constituentExchangeIds != null) {
				for (ExchangeId toAdd : constituentExchangeIds) {
					this.constituentExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Index.IndexBuilder setConstituentExchangeId(List<? extends ExchangeId> constituentExchangeIds) {
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
		@RosettaAttribute("futureId")
		public Index.IndexBuilder setFutureId(FutureId futureId) {
			this.futureId = futureId==null?null:futureId.toBuilder();
			return this;
		}
		
		@Override
		public Index build() {
			return new Index.IndexImpl(this);
		}
		
		@Override
		public Index.IndexBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Index.IndexBuilder prune() {
			super.prune();
			if (futureId!=null && !futureId.prune().hasData()) futureId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFutureId()!=null && getFutureId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Index.IndexBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Index.IndexBuilder o = (Index.IndexBuilder) other;
			
			merger.mergeRosetta(getFutureId(), o.getFutureId(), this::setFutureId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Index _that = getType().cast(o);
		
			if (!Objects.equals(futureId, _that.getFutureId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (futureId != null ? futureId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexBuilder {" +
				"futureId=" + this.futureId +
			'}' + " " + super.toString();
		}
	}
}
