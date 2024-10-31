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
import fpml.confirmation.ExchangeTraded;
import fpml.confirmation.ExchangeTraded.ExchangeTradedBuilder;
import fpml.confirmation.ExchangeTraded.ExchangeTradedBuilderImpl;
import fpml.confirmation.ExchangeTraded.ExchangeTradedImpl;
import fpml.confirmation.IdentifiedCurrency;
import fpml.confirmation.InstrumentId;
import fpml.confirmation.ProductReference;
import fpml.confirmation.UnderlyingAssetType;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilder;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl;
import fpml.confirmation.UnderlyingAssetType.UnderlyingAssetTypeImpl;
import fpml.confirmation.meta.ExchangeTradedMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base class for all exchange traded financial products.
 * @version ${project.version}
 */
@RosettaDataType(value="ExchangeTraded", builder=ExchangeTraded.ExchangeTradedBuilderImpl.class, version="${project.version}")
public interface ExchangeTraded extends UnderlyingAssetType {

	ExchangeTradedMeta metaData = new ExchangeTradedMeta();

	/*********************** Getter Methods  ***********************/
	ExchangeIdentifierModel getExchangeIdentifierModel();

	/*********************** Build Methods  ***********************/
	ExchangeTraded build();
	
	ExchangeTraded.ExchangeTradedBuilder toBuilder();
	
	static ExchangeTraded.ExchangeTradedBuilder builder() {
		return new ExchangeTraded.ExchangeTradedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTraded> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExchangeTraded> getType() {
		return ExchangeTraded.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeTradedBuilder extends ExchangeTraded, UnderlyingAssetType.UnderlyingAssetTypeBuilder {
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder getOrCreateExchangeIdentifierModel();
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder getExchangeIdentifierModel();
		ExchangeTraded.ExchangeTradedBuilder setId(String id);
		ExchangeTraded.ExchangeTradedBuilder addInstrumentId(InstrumentId instrumentId0);
		ExchangeTraded.ExchangeTradedBuilder addInstrumentId(InstrumentId instrumentId1, int _idx);
		ExchangeTraded.ExchangeTradedBuilder addInstrumentId(List<? extends InstrumentId> instrumentId2);
		ExchangeTraded.ExchangeTradedBuilder setInstrumentId(List<? extends InstrumentId> instrumentId3);
		ExchangeTraded.ExchangeTradedBuilder setDescription(String description);
		ExchangeTraded.ExchangeTradedBuilder setCurrency(IdentifiedCurrency currency);
		ExchangeTraded.ExchangeTradedBuilder setExchangeId(ExchangeId exchangeId);
		ExchangeTraded.ExchangeTradedBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		ExchangeTraded.ExchangeTradedBuilder setDefinition(ProductReference definition);
		ExchangeTraded.ExchangeTradedBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel);

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
		}
		

		ExchangeTraded.ExchangeTradedBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTraded  ***********************/
	class ExchangeTradedImpl extends UnderlyingAssetType.UnderlyingAssetTypeImpl implements ExchangeTraded {
		private final ExchangeIdentifierModel exchangeIdentifierModel;
		
		protected ExchangeTradedImpl(ExchangeTraded.ExchangeTradedBuilder builder) {
			super(builder);
			this.exchangeIdentifierModel = ofNullable(builder.getExchangeIdentifierModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public ExchangeIdentifierModel getExchangeIdentifierModel() {
			return exchangeIdentifierModel;
		}
		
		@Override
		public ExchangeTraded build() {
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder toBuilder() {
			ExchangeTraded.ExchangeTradedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTraded.ExchangeTradedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExchangeIdentifierModel()).ifPresent(builder::setExchangeIdentifierModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTraded _that = getType().cast(o);
		
			if (!Objects.equals(exchangeIdentifierModel, _that.getExchangeIdentifierModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exchangeIdentifierModel != null ? exchangeIdentifierModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTraded {" +
				"exchangeIdentifierModel=" + this.exchangeIdentifierModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExchangeTraded  ***********************/
	class ExchangeTradedBuilderImpl extends UnderlyingAssetType.UnderlyingAssetTypeBuilderImpl  implements ExchangeTraded.ExchangeTradedBuilder {
	
		protected ExchangeIdentifierModel.ExchangeIdentifierModelBuilder exchangeIdentifierModel;
	
		public ExchangeTradedBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder getExchangeIdentifierModel() {
			return exchangeIdentifierModel;
		}
		
		@Override
		public ExchangeIdentifierModel.ExchangeIdentifierModelBuilder getOrCreateExchangeIdentifierModel() {
			ExchangeIdentifierModel.ExchangeIdentifierModelBuilder result;
			if (exchangeIdentifierModel!=null) {
				result = exchangeIdentifierModel;
			}
			else {
				result = exchangeIdentifierModel = ExchangeIdentifierModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public ExchangeTraded.ExchangeTradedBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("instrumentId")
		public ExchangeTraded.ExchangeTradedBuilder addInstrumentId(InstrumentId instrumentId) {
			if (instrumentId!=null) this.instrumentId.add(instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder addInstrumentId(InstrumentId instrumentId, int _idx) {
			getIndex(this.instrumentId, _idx, () -> instrumentId.toBuilder());
			return this;
		}
		@Override 
		public ExchangeTraded.ExchangeTradedBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public ExchangeTraded.ExchangeTradedBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTraded.ExchangeTradedBuilder setDescription(String description) {
			this.description = description==null?null:description;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public ExchangeTraded.ExchangeTradedBuilder setCurrency(IdentifiedCurrency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public ExchangeTraded.ExchangeTradedBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clearanceSystem")
		public ExchangeTraded.ExchangeTradedBuilder setClearanceSystem(ClearanceSystem clearanceSystem) {
			this.clearanceSystem = clearanceSystem==null?null:clearanceSystem.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("definition")
		public ExchangeTraded.ExchangeTradedBuilder setDefinition(ProductReference definition) {
			this.definition = definition==null?null:definition.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public ExchangeTraded.ExchangeTradedBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel) {
			this.exchangeIdentifierModel = exchangeIdentifierModel==null?null:exchangeIdentifierModel.toBuilder();
			return this;
		}
		
		@Override
		public ExchangeTraded build() {
			return new ExchangeTraded.ExchangeTradedImpl(this);
		}
		
		@Override
		public ExchangeTraded.ExchangeTradedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTraded.ExchangeTradedBuilder prune() {
			super.prune();
			if (exchangeIdentifierModel!=null && !exchangeIdentifierModel.prune().hasData()) exchangeIdentifierModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExchangeIdentifierModel()!=null && getExchangeIdentifierModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTraded.ExchangeTradedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			ExchangeTraded.ExchangeTradedBuilder o = (ExchangeTraded.ExchangeTradedBuilder) other;
			
			merger.mergeRosetta(getExchangeIdentifierModel(), o.getExchangeIdentifierModel(), this::setExchangeIdentifierModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTraded _that = getType().cast(o);
		
			if (!Objects.equals(exchangeIdentifierModel, _that.getExchangeIdentifierModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (exchangeIdentifierModel != null ? exchangeIdentifierModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedBuilder {" +
				"exchangeIdentifierModel=" + this.exchangeIdentifierModel +
			'}' + " " + super.toString();
		}
	}
}
