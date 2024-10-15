package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.ClearanceSystem;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.ExchangeIdentifierModel;
import fpml.confirmation.ExchangeTraded;
import fpml.confirmation.ExchangeTraded.ExchangeTradedBuilder;
import fpml.confirmation.ExchangeTraded.ExchangeTradedBuilderImpl;
import fpml.confirmation.ExchangeTraded.ExchangeTradedImpl;
import fpml.confirmation.ExchangeTradedCalculatedPrice;
import fpml.confirmation.ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder;
import fpml.confirmation.ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilderImpl;
import fpml.confirmation.ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceImpl;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.meta.ExchangeTradedCalculatedPriceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Abstract base class for all exchange traded financial products with a price which is calculated from exchange traded constituents.
 * @version ${project.version}
 */
@RosettaDataType(value="ExchangeTradedCalculatedPrice", builder=ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilderImpl.class, version="${project.version}")
public interface ExchangeTradedCalculatedPrice extends ExchangeTraded {

	ExchangeTradedCalculatedPriceMeta metaData = new ExchangeTradedCalculatedPriceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identification of all the exchanges where constituents are traded. The term &quot;Exchange&quot; is assumed to have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 */
	List<? extends ExchangeId> getConstituentExchangeId();

	/*********************** Build Methods  ***********************/
	ExchangeTradedCalculatedPrice build();
	
	ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder toBuilder();
	
	static ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder builder() {
		return new ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTradedCalculatedPrice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExchangeTradedCalculatedPrice> getType() {
		return ExchangeTradedCalculatedPrice.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeTradedCalculatedPriceBuilder extends ExchangeTradedCalculatedPrice, ExchangeTraded.ExchangeTradedBuilder {
		ExchangeId.ExchangeIdBuilder getOrCreateConstituentExchangeId(int _index);
		List<? extends ExchangeId.ExchangeIdBuilder> getConstituentExchangeId();
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setId(String id);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentId(InstrumentId instrumentId0);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setDescription(String description);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setCurrency(IdentifiedCurrency currency);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setExchangeId(ExchangeId exchangeId);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setDefinition(ProductReference definition);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addConstituentExchangeId(ExchangeId constituentExchangeId0);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addConstituentExchangeId(ExchangeId constituentExchangeId1, int _idx);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addConstituentExchangeId(List<? extends ExchangeId> constituentExchangeId2);
		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setConstituentExchangeId(List<? extends ExchangeId> constituentExchangeId3);

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
		}
		

		ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTradedCalculatedPrice  ***********************/
	class ExchangeTradedCalculatedPriceImpl extends ExchangeTraded.ExchangeTradedImpl implements ExchangeTradedCalculatedPrice {
		private final List<? extends ExchangeId> constituentExchangeId;
		
		protected ExchangeTradedCalculatedPriceImpl(ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder builder) {
			super(builder);
			this.constituentExchangeId = ofNullable(builder.getConstituentExchangeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("constituentExchangeId")
		public List<? extends ExchangeId> getConstituentExchangeId() {
			return constituentExchangeId;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice build() {
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder toBuilder() {
			ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getConstituentExchangeId()).ifPresent(builder::setConstituentExchangeId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedCalculatedPrice _that = getType().cast(o);
		
			if (!ListEquals.listEquals(constituentExchangeId, _that.getConstituentExchangeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (constituentExchangeId != null ? constituentExchangeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedCalculatedPrice {" +
				"constituentExchangeId=" + this.constituentExchangeId +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExchangeTradedCalculatedPrice  ***********************/
	class ExchangeTradedCalculatedPriceBuilderImpl extends ExchangeTraded.ExchangeTradedBuilderImpl  implements ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder {
	
		protected List<ExchangeId.ExchangeIdBuilder> constituentExchangeId = new ArrayList<>();
	
		public ExchangeTradedCalculatedPriceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("constituentExchangeId")
		public List<? extends ExchangeId.ExchangeIdBuilder> getConstituentExchangeId() {
			return constituentExchangeId;
		}
		
		public ExchangeId.ExchangeIdBuilder getOrCreateConstituentExchangeId(int _index) {
		
			if (constituentExchangeId==null) {
				this.constituentExchangeId = new ArrayList<>();
			}
			ExchangeId.ExchangeIdBuilder result;
			return getIndex(constituentExchangeId, _index, () -> {
						ExchangeId.ExchangeIdBuilder newConstituentExchangeId = ExchangeId.builder();
						return newConstituentExchangeId;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("instrumentId")
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel) {
			this.exchangeIdentifierModel = exchangeIdentifierModel==null?null:exchangeIdentifierModel.toBuilder();
			return this;
		}
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addConstituentExchangeId(ExchangeId constituentExchangeId) {
			if (constituentExchangeId!=null) this.constituentExchangeId.add(constituentExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addConstituentExchangeId(ExchangeId constituentExchangeId, int _idx) {
			getIndex(this.constituentExchangeId, _idx, () -> constituentExchangeId.toBuilder());
			return this;
		}
		@Override 
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder addConstituentExchangeId(List<? extends ExchangeId> constituentExchangeIds) {
			if (constituentExchangeIds != null) {
				for (ExchangeId toAdd : constituentExchangeIds) {
					this.constituentExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("constituentExchangeId")
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder setConstituentExchangeId(List<? extends ExchangeId> constituentExchangeIds) {
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
		public ExchangeTradedCalculatedPrice build() {
			return new ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceImpl(this);
		}
		
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder prune() {
			super.prune();
			constituentExchangeId = constituentExchangeId.stream().filter(b->b!=null).<ExchangeId.ExchangeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getConstituentExchangeId()!=null && getConstituentExchangeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder o = (ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder) other;
			
			merger.mergeRosetta(getConstituentExchangeId(), o.getConstituentExchangeId(), this::getOrCreateConstituentExchangeId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedCalculatedPrice _that = getType().cast(o);
		
			if (!ListEquals.listEquals(constituentExchangeId, _that.getConstituentExchangeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (constituentExchangeId != null ? constituentExchangeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedCalculatedPriceBuilder {" +
				"constituentExchangeId=" + this.constituentExchangeId +
			'}' + " " + super.toString();
		}
	}
}
