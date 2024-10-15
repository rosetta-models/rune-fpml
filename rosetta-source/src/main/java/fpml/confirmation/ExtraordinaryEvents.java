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
import fpml.confirmation.AdditionalDisruptionEvents;
import fpml.confirmation.EquityCorporateEvents;
import fpml.confirmation.ExchangeIdentifierModel;
import fpml.confirmation.ExtraordinaryEvents;
import fpml.confirmation.ExtraordinaryEvents.ExtraordinaryEventsBuilder;
import fpml.confirmation.ExtraordinaryEvents.ExtraordinaryEventsBuilderImpl;
import fpml.confirmation.ExtraordinaryEvents.ExtraordinaryEventsImpl;
import fpml.confirmation.IndexAdjustmentEvents;
import fpml.confirmation.NationalisationOrInsolvencyOrDelistingEventEnum;
import fpml.confirmation.Representations;
import fpml.confirmation.meta.ExtraordinaryEventsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Where the underlying is shares, defines market events affecting the issuer of those shares that may require the terms of the transaction to be adjusted.
 * @version ${project.version}
 */
@RosettaDataType(value="ExtraordinaryEvents", builder=ExtraordinaryEvents.ExtraordinaryEventsBuilderImpl.class, version="${project.version}")
public interface ExtraordinaryEvents extends RosettaModelObject {

	ExtraordinaryEventsMeta metaData = new ExtraordinaryEventsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Occurs when the underlying ceases to exist following a merger between the Issuer and another company.
	 */
	EquityCorporateEvents getMergerEvents();
	/**
	 * DEPRECATED. If present and true, then tender offer is applicable.
	 */
	Boolean getTenderOffer();
	/**
	 * ISDA 2002 Equity Tender Offer Events.
	 */
	EquityCorporateEvents getTenderOfferEvents();
	/**
	 * If present and true, then composition of combined consideration is applicable.
	 */
	Boolean getCompositionOfCombinedConsideration();
	/**
	 * ISDA 2002 Equity Index Adjustment Events.
	 */
	IndexAdjustmentEvents getIndexAdjustmentEvents();
	/**
	 * ISDA 2002 Equity Additional Disruption Events.
	 */
	AdditionalDisruptionEvents getAdditionalDisruptionEvents();
	/**
	 * If true, failure to deliver is applicable.
	 */
	Boolean getFailureToDeliver();
	/**
	 * ISDA 2002 Equity Derivative Representations.
	 */
	Representations getRepresentations();
	/**
	 * The terms &quot;Nationalisation&quot; and &quot;Insolvency&quot; have the meaning as defined in the ISDA 2002 Equity Derivatives Definitions.
	 */
	NationalisationOrInsolvencyOrDelistingEventEnum getNationalisationOrInsolvency();
	/**
	 * The term &quot;Delisting&quot; has the meaning defined in the ISDA 2002 Equity Derivatives Definitions.
	 */
	NationalisationOrInsolvencyOrDelistingEventEnum getDelisting();
	ExchangeIdentifierModel getExchangeIdentifierModel();

	/*********************** Build Methods  ***********************/
	ExtraordinaryEvents build();
	
	ExtraordinaryEvents.ExtraordinaryEventsBuilder toBuilder();
	
	static ExtraordinaryEvents.ExtraordinaryEventsBuilder builder() {
		return new ExtraordinaryEvents.ExtraordinaryEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExtraordinaryEvents> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ExtraordinaryEvents> getType() {
		return ExtraordinaryEvents.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mergerEvents"), processor, EquityCorporateEvents.class, getMergerEvents());
		processor.processBasic(path.newSubPath("tenderOffer"), Boolean.class, getTenderOffer(), this);
		processRosetta(path.newSubPath("tenderOfferEvents"), processor, EquityCorporateEvents.class, getTenderOfferEvents());
		processor.processBasic(path.newSubPath("compositionOfCombinedConsideration"), Boolean.class, getCompositionOfCombinedConsideration(), this);
		processRosetta(path.newSubPath("indexAdjustmentEvents"), processor, IndexAdjustmentEvents.class, getIndexAdjustmentEvents());
		processRosetta(path.newSubPath("additionalDisruptionEvents"), processor, AdditionalDisruptionEvents.class, getAdditionalDisruptionEvents());
		processor.processBasic(path.newSubPath("failureToDeliver"), Boolean.class, getFailureToDeliver(), this);
		processRosetta(path.newSubPath("representations"), processor, Representations.class, getRepresentations());
		processor.processBasic(path.newSubPath("nationalisationOrInsolvency"), NationalisationOrInsolvencyOrDelistingEventEnum.class, getNationalisationOrInsolvency(), this);
		processor.processBasic(path.newSubPath("delisting"), NationalisationOrInsolvencyOrDelistingEventEnum.class, getDelisting(), this);
		processRosetta(path.newSubPath("exchangeIdentifierModel"), processor, ExchangeIdentifierModel.class, getExchangeIdentifierModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExtraordinaryEventsBuilder extends ExtraordinaryEvents, RosettaModelObjectBuilder {
		EquityCorporateEvents.EquityCorporateEventsBuilder getOrCreateMergerEvents();
		EquityCorporateEvents.EquityCorporateEventsBuilder getMergerEvents();
		EquityCorporateEvents.EquityCorporateEventsBuilder getOrCreateTenderOfferEvents();
		EquityCorporateEvents.EquityCorporateEventsBuilder getTenderOfferEvents();
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder getOrCreateIndexAdjustmentEvents();
		IndexAdjustmentEvents.IndexAdjustmentEventsBuilder getIndexAdjustmentEvents();
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder getOrCreateAdditionalDisruptionEvents();
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder getAdditionalDisruptionEvents();
		Representations.RepresentationsBuilder getOrCreateRepresentations();
		Representations.RepresentationsBuilder getRepresentations();
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder getOrCreateExchangeIdentifierModel();
		ExchangeIdentifierModel.ExchangeIdentifierModelBuilder getExchangeIdentifierModel();
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setMergerEvents(EquityCorporateEvents mergerEvents);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setTenderOffer(Boolean tenderOffer);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setTenderOfferEvents(EquityCorporateEvents tenderOfferEvents);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setCompositionOfCombinedConsideration(Boolean compositionOfCombinedConsideration);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setIndexAdjustmentEvents(IndexAdjustmentEvents indexAdjustmentEvents);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setAdditionalDisruptionEvents(AdditionalDisruptionEvents additionalDisruptionEvents);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setFailureToDeliver(Boolean failureToDeliver);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setRepresentations(Representations representations);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setNationalisationOrInsolvency(NationalisationOrInsolvencyOrDelistingEventEnum nationalisationOrInsolvency);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setDelisting(NationalisationOrInsolvencyOrDelistingEventEnum delisting);
		ExtraordinaryEvents.ExtraordinaryEventsBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mergerEvents"), processor, EquityCorporateEvents.EquityCorporateEventsBuilder.class, getMergerEvents());
			processor.processBasic(path.newSubPath("tenderOffer"), Boolean.class, getTenderOffer(), this);
			processRosetta(path.newSubPath("tenderOfferEvents"), processor, EquityCorporateEvents.EquityCorporateEventsBuilder.class, getTenderOfferEvents());
			processor.processBasic(path.newSubPath("compositionOfCombinedConsideration"), Boolean.class, getCompositionOfCombinedConsideration(), this);
			processRosetta(path.newSubPath("indexAdjustmentEvents"), processor, IndexAdjustmentEvents.IndexAdjustmentEventsBuilder.class, getIndexAdjustmentEvents());
			processRosetta(path.newSubPath("additionalDisruptionEvents"), processor, AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder.class, getAdditionalDisruptionEvents());
			processor.processBasic(path.newSubPath("failureToDeliver"), Boolean.class, getFailureToDeliver(), this);
			processRosetta(path.newSubPath("representations"), processor, Representations.RepresentationsBuilder.class, getRepresentations());
			processor.processBasic(path.newSubPath("nationalisationOrInsolvency"), NationalisationOrInsolvencyOrDelistingEventEnum.class, getNationalisationOrInsolvency(), this);
			processor.processBasic(path.newSubPath("delisting"), NationalisationOrInsolvencyOrDelistingEventEnum.class, getDelisting(), this);
			processRosetta(path.newSubPath("exchangeIdentifierModel"), processor, ExchangeIdentifierModel.ExchangeIdentifierModelBuilder.class, getExchangeIdentifierModel());
		}
		

		ExtraordinaryEvents.ExtraordinaryEventsBuilder prune();
	}

	/*********************** Immutable Implementation of ExtraordinaryEvents  ***********************/
	class ExtraordinaryEventsImpl implements ExtraordinaryEvents {
		private final EquityCorporateEvents mergerEvents;
		private final Boolean tenderOffer;
		private final EquityCorporateEvents tenderOfferEvents;
		private final Boolean compositionOfCombinedConsideration;
		private final IndexAdjustmentEvents indexAdjustmentEvents;
		private final AdditionalDisruptionEvents additionalDisruptionEvents;
		private final Boolean failureToDeliver;
		private final Representations representations;
		private final NationalisationOrInsolvencyOrDelistingEventEnum nationalisationOrInsolvency;
		private final NationalisationOrInsolvencyOrDelistingEventEnum delisting;
		private final ExchangeIdentifierModel exchangeIdentifierModel;
		
		protected ExtraordinaryEventsImpl(ExtraordinaryEvents.ExtraordinaryEventsBuilder builder) {
			this.mergerEvents = ofNullable(builder.getMergerEvents()).map(f->f.build()).orElse(null);
			this.tenderOffer = builder.getTenderOffer();
			this.tenderOfferEvents = ofNullable(builder.getTenderOfferEvents()).map(f->f.build()).orElse(null);
			this.compositionOfCombinedConsideration = builder.getCompositionOfCombinedConsideration();
			this.indexAdjustmentEvents = ofNullable(builder.getIndexAdjustmentEvents()).map(f->f.build()).orElse(null);
			this.additionalDisruptionEvents = ofNullable(builder.getAdditionalDisruptionEvents()).map(f->f.build()).orElse(null);
			this.failureToDeliver = builder.getFailureToDeliver();
			this.representations = ofNullable(builder.getRepresentations()).map(f->f.build()).orElse(null);
			this.nationalisationOrInsolvency = builder.getNationalisationOrInsolvency();
			this.delisting = builder.getDelisting();
			this.exchangeIdentifierModel = ofNullable(builder.getExchangeIdentifierModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mergerEvents")
		public EquityCorporateEvents getMergerEvents() {
			return mergerEvents;
		}
		
		@Override
		@RosettaAttribute("tenderOffer")
		public Boolean getTenderOffer() {
			return tenderOffer;
		}
		
		@Override
		@RosettaAttribute("tenderOfferEvents")
		public EquityCorporateEvents getTenderOfferEvents() {
			return tenderOfferEvents;
		}
		
		@Override
		@RosettaAttribute("compositionOfCombinedConsideration")
		public Boolean getCompositionOfCombinedConsideration() {
			return compositionOfCombinedConsideration;
		}
		
		@Override
		@RosettaAttribute("indexAdjustmentEvents")
		public IndexAdjustmentEvents getIndexAdjustmentEvents() {
			return indexAdjustmentEvents;
		}
		
		@Override
		@RosettaAttribute("additionalDisruptionEvents")
		public AdditionalDisruptionEvents getAdditionalDisruptionEvents() {
			return additionalDisruptionEvents;
		}
		
		@Override
		@RosettaAttribute("failureToDeliver")
		public Boolean getFailureToDeliver() {
			return failureToDeliver;
		}
		
		@Override
		@RosettaAttribute("representations")
		public Representations getRepresentations() {
			return representations;
		}
		
		@Override
		@RosettaAttribute("nationalisationOrInsolvency")
		public NationalisationOrInsolvencyOrDelistingEventEnum getNationalisationOrInsolvency() {
			return nationalisationOrInsolvency;
		}
		
		@Override
		@RosettaAttribute("delisting")
		public NationalisationOrInsolvencyOrDelistingEventEnum getDelisting() {
			return delisting;
		}
		
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public ExchangeIdentifierModel getExchangeIdentifierModel() {
			return exchangeIdentifierModel;
		}
		
		@Override
		public ExtraordinaryEvents build() {
			return this;
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder toBuilder() {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExtraordinaryEvents.ExtraordinaryEventsBuilder builder) {
			ofNullable(getMergerEvents()).ifPresent(builder::setMergerEvents);
			ofNullable(getTenderOffer()).ifPresent(builder::setTenderOffer);
			ofNullable(getTenderOfferEvents()).ifPresent(builder::setTenderOfferEvents);
			ofNullable(getCompositionOfCombinedConsideration()).ifPresent(builder::setCompositionOfCombinedConsideration);
			ofNullable(getIndexAdjustmentEvents()).ifPresent(builder::setIndexAdjustmentEvents);
			ofNullable(getAdditionalDisruptionEvents()).ifPresent(builder::setAdditionalDisruptionEvents);
			ofNullable(getFailureToDeliver()).ifPresent(builder::setFailureToDeliver);
			ofNullable(getRepresentations()).ifPresent(builder::setRepresentations);
			ofNullable(getNationalisationOrInsolvency()).ifPresent(builder::setNationalisationOrInsolvency);
			ofNullable(getDelisting()).ifPresent(builder::setDelisting);
			ofNullable(getExchangeIdentifierModel()).ifPresent(builder::setExchangeIdentifierModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtraordinaryEvents _that = getType().cast(o);
		
			if (!Objects.equals(mergerEvents, _that.getMergerEvents())) return false;
			if (!Objects.equals(tenderOffer, _that.getTenderOffer())) return false;
			if (!Objects.equals(tenderOfferEvents, _that.getTenderOfferEvents())) return false;
			if (!Objects.equals(compositionOfCombinedConsideration, _that.getCompositionOfCombinedConsideration())) return false;
			if (!Objects.equals(indexAdjustmentEvents, _that.getIndexAdjustmentEvents())) return false;
			if (!Objects.equals(additionalDisruptionEvents, _that.getAdditionalDisruptionEvents())) return false;
			if (!Objects.equals(failureToDeliver, _that.getFailureToDeliver())) return false;
			if (!Objects.equals(representations, _that.getRepresentations())) return false;
			if (!Objects.equals(nationalisationOrInsolvency, _that.getNationalisationOrInsolvency())) return false;
			if (!Objects.equals(delisting, _that.getDelisting())) return false;
			if (!Objects.equals(exchangeIdentifierModel, _that.getExchangeIdentifierModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mergerEvents != null ? mergerEvents.hashCode() : 0);
			_result = 31 * _result + (tenderOffer != null ? tenderOffer.hashCode() : 0);
			_result = 31 * _result + (tenderOfferEvents != null ? tenderOfferEvents.hashCode() : 0);
			_result = 31 * _result + (compositionOfCombinedConsideration != null ? compositionOfCombinedConsideration.hashCode() : 0);
			_result = 31 * _result + (indexAdjustmentEvents != null ? indexAdjustmentEvents.hashCode() : 0);
			_result = 31 * _result + (additionalDisruptionEvents != null ? additionalDisruptionEvents.hashCode() : 0);
			_result = 31 * _result + (failureToDeliver != null ? failureToDeliver.hashCode() : 0);
			_result = 31 * _result + (representations != null ? representations.hashCode() : 0);
			_result = 31 * _result + (nationalisationOrInsolvency != null ? nationalisationOrInsolvency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delisting != null ? delisting.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exchangeIdentifierModel != null ? exchangeIdentifierModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtraordinaryEvents {" +
				"mergerEvents=" + this.mergerEvents + ", " +
				"tenderOffer=" + this.tenderOffer + ", " +
				"tenderOfferEvents=" + this.tenderOfferEvents + ", " +
				"compositionOfCombinedConsideration=" + this.compositionOfCombinedConsideration + ", " +
				"indexAdjustmentEvents=" + this.indexAdjustmentEvents + ", " +
				"additionalDisruptionEvents=" + this.additionalDisruptionEvents + ", " +
				"failureToDeliver=" + this.failureToDeliver + ", " +
				"representations=" + this.representations + ", " +
				"nationalisationOrInsolvency=" + this.nationalisationOrInsolvency + ", " +
				"delisting=" + this.delisting + ", " +
				"exchangeIdentifierModel=" + this.exchangeIdentifierModel +
			'}';
		}
	}

	/*********************** Builder Implementation of ExtraordinaryEvents  ***********************/
	class ExtraordinaryEventsBuilderImpl implements ExtraordinaryEvents.ExtraordinaryEventsBuilder {
	
		protected EquityCorporateEvents.EquityCorporateEventsBuilder mergerEvents;
		protected Boolean tenderOffer;
		protected EquityCorporateEvents.EquityCorporateEventsBuilder tenderOfferEvents;
		protected Boolean compositionOfCombinedConsideration;
		protected IndexAdjustmentEvents.IndexAdjustmentEventsBuilder indexAdjustmentEvents;
		protected AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder additionalDisruptionEvents;
		protected Boolean failureToDeliver;
		protected Representations.RepresentationsBuilder representations;
		protected NationalisationOrInsolvencyOrDelistingEventEnum nationalisationOrInsolvency;
		protected NationalisationOrInsolvencyOrDelistingEventEnum delisting;
		protected ExchangeIdentifierModel.ExchangeIdentifierModelBuilder exchangeIdentifierModel;
	
		public ExtraordinaryEventsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("mergerEvents")
		public EquityCorporateEvents.EquityCorporateEventsBuilder getMergerEvents() {
			return mergerEvents;
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder getOrCreateMergerEvents() {
			EquityCorporateEvents.EquityCorporateEventsBuilder result;
			if (mergerEvents!=null) {
				result = mergerEvents;
			}
			else {
				result = mergerEvents = EquityCorporateEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tenderOffer")
		public Boolean getTenderOffer() {
			return tenderOffer;
		}
		
		@Override
		@RosettaAttribute("tenderOfferEvents")
		public EquityCorporateEvents.EquityCorporateEventsBuilder getTenderOfferEvents() {
			return tenderOfferEvents;
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder getOrCreateTenderOfferEvents() {
			EquityCorporateEvents.EquityCorporateEventsBuilder result;
			if (tenderOfferEvents!=null) {
				result = tenderOfferEvents;
			}
			else {
				result = tenderOfferEvents = EquityCorporateEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compositionOfCombinedConsideration")
		public Boolean getCompositionOfCombinedConsideration() {
			return compositionOfCombinedConsideration;
		}
		
		@Override
		@RosettaAttribute("indexAdjustmentEvents")
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder getIndexAdjustmentEvents() {
			return indexAdjustmentEvents;
		}
		
		@Override
		public IndexAdjustmentEvents.IndexAdjustmentEventsBuilder getOrCreateIndexAdjustmentEvents() {
			IndexAdjustmentEvents.IndexAdjustmentEventsBuilder result;
			if (indexAdjustmentEvents!=null) {
				result = indexAdjustmentEvents;
			}
			else {
				result = indexAdjustmentEvents = IndexAdjustmentEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalDisruptionEvents")
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder getAdditionalDisruptionEvents() {
			return additionalDisruptionEvents;
		}
		
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder getOrCreateAdditionalDisruptionEvents() {
			AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder result;
			if (additionalDisruptionEvents!=null) {
				result = additionalDisruptionEvents;
			}
			else {
				result = additionalDisruptionEvents = AdditionalDisruptionEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("failureToDeliver")
		public Boolean getFailureToDeliver() {
			return failureToDeliver;
		}
		
		@Override
		@RosettaAttribute("representations")
		public Representations.RepresentationsBuilder getRepresentations() {
			return representations;
		}
		
		@Override
		public Representations.RepresentationsBuilder getOrCreateRepresentations() {
			Representations.RepresentationsBuilder result;
			if (representations!=null) {
				result = representations;
			}
			else {
				result = representations = Representations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nationalisationOrInsolvency")
		public NationalisationOrInsolvencyOrDelistingEventEnum getNationalisationOrInsolvency() {
			return nationalisationOrInsolvency;
		}
		
		@Override
		@RosettaAttribute("delisting")
		public NationalisationOrInsolvencyOrDelistingEventEnum getDelisting() {
			return delisting;
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
		@RosettaAttribute("mergerEvents")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setMergerEvents(EquityCorporateEvents mergerEvents) {
			this.mergerEvents = mergerEvents==null?null:mergerEvents.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("tenderOffer")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setTenderOffer(Boolean tenderOffer) {
			this.tenderOffer = tenderOffer==null?null:tenderOffer;
			return this;
		}
		@Override
		@RosettaAttribute("tenderOfferEvents")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setTenderOfferEvents(EquityCorporateEvents tenderOfferEvents) {
			this.tenderOfferEvents = tenderOfferEvents==null?null:tenderOfferEvents.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("compositionOfCombinedConsideration")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setCompositionOfCombinedConsideration(Boolean compositionOfCombinedConsideration) {
			this.compositionOfCombinedConsideration = compositionOfCombinedConsideration==null?null:compositionOfCombinedConsideration;
			return this;
		}
		@Override
		@RosettaAttribute("indexAdjustmentEvents")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setIndexAdjustmentEvents(IndexAdjustmentEvents indexAdjustmentEvents) {
			this.indexAdjustmentEvents = indexAdjustmentEvents==null?null:indexAdjustmentEvents.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("additionalDisruptionEvents")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setAdditionalDisruptionEvents(AdditionalDisruptionEvents additionalDisruptionEvents) {
			this.additionalDisruptionEvents = additionalDisruptionEvents==null?null:additionalDisruptionEvents.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("failureToDeliver")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setFailureToDeliver(Boolean failureToDeliver) {
			this.failureToDeliver = failureToDeliver==null?null:failureToDeliver;
			return this;
		}
		@Override
		@RosettaAttribute("representations")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setRepresentations(Representations representations) {
			this.representations = representations==null?null:representations.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("nationalisationOrInsolvency")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setNationalisationOrInsolvency(NationalisationOrInsolvencyOrDelistingEventEnum nationalisationOrInsolvency) {
			this.nationalisationOrInsolvency = nationalisationOrInsolvency==null?null:nationalisationOrInsolvency;
			return this;
		}
		@Override
		@RosettaAttribute("delisting")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setDelisting(NationalisationOrInsolvencyOrDelistingEventEnum delisting) {
			this.delisting = delisting==null?null:delisting;
			return this;
		}
		@Override
		@RosettaAttribute("exchangeIdentifierModel")
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder setExchangeIdentifierModel(ExchangeIdentifierModel exchangeIdentifierModel) {
			this.exchangeIdentifierModel = exchangeIdentifierModel==null?null:exchangeIdentifierModel.toBuilder();
			return this;
		}
		
		@Override
		public ExtraordinaryEvents build() {
			return new ExtraordinaryEvents.ExtraordinaryEventsImpl(this);
		}
		
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder prune() {
			if (mergerEvents!=null && !mergerEvents.prune().hasData()) mergerEvents = null;
			if (tenderOfferEvents!=null && !tenderOfferEvents.prune().hasData()) tenderOfferEvents = null;
			if (indexAdjustmentEvents!=null && !indexAdjustmentEvents.prune().hasData()) indexAdjustmentEvents = null;
			if (additionalDisruptionEvents!=null && !additionalDisruptionEvents.prune().hasData()) additionalDisruptionEvents = null;
			if (representations!=null && !representations.prune().hasData()) representations = null;
			if (exchangeIdentifierModel!=null && !exchangeIdentifierModel.prune().hasData()) exchangeIdentifierModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMergerEvents()!=null && getMergerEvents().hasData()) return true;
			if (getTenderOffer()!=null) return true;
			if (getTenderOfferEvents()!=null && getTenderOfferEvents().hasData()) return true;
			if (getCompositionOfCombinedConsideration()!=null) return true;
			if (getIndexAdjustmentEvents()!=null && getIndexAdjustmentEvents().hasData()) return true;
			if (getAdditionalDisruptionEvents()!=null && getAdditionalDisruptionEvents().hasData()) return true;
			if (getFailureToDeliver()!=null) return true;
			if (getRepresentations()!=null && getRepresentations().hasData()) return true;
			if (getNationalisationOrInsolvency()!=null) return true;
			if (getDelisting()!=null) return true;
			if (getExchangeIdentifierModel()!=null && getExchangeIdentifierModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtraordinaryEvents.ExtraordinaryEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExtraordinaryEvents.ExtraordinaryEventsBuilder o = (ExtraordinaryEvents.ExtraordinaryEventsBuilder) other;
			
			merger.mergeRosetta(getMergerEvents(), o.getMergerEvents(), this::setMergerEvents);
			merger.mergeRosetta(getTenderOfferEvents(), o.getTenderOfferEvents(), this::setTenderOfferEvents);
			merger.mergeRosetta(getIndexAdjustmentEvents(), o.getIndexAdjustmentEvents(), this::setIndexAdjustmentEvents);
			merger.mergeRosetta(getAdditionalDisruptionEvents(), o.getAdditionalDisruptionEvents(), this::setAdditionalDisruptionEvents);
			merger.mergeRosetta(getRepresentations(), o.getRepresentations(), this::setRepresentations);
			merger.mergeRosetta(getExchangeIdentifierModel(), o.getExchangeIdentifierModel(), this::setExchangeIdentifierModel);
			
			merger.mergeBasic(getTenderOffer(), o.getTenderOffer(), this::setTenderOffer);
			merger.mergeBasic(getCompositionOfCombinedConsideration(), o.getCompositionOfCombinedConsideration(), this::setCompositionOfCombinedConsideration);
			merger.mergeBasic(getFailureToDeliver(), o.getFailureToDeliver(), this::setFailureToDeliver);
			merger.mergeBasic(getNationalisationOrInsolvency(), o.getNationalisationOrInsolvency(), this::setNationalisationOrInsolvency);
			merger.mergeBasic(getDelisting(), o.getDelisting(), this::setDelisting);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtraordinaryEvents _that = getType().cast(o);
		
			if (!Objects.equals(mergerEvents, _that.getMergerEvents())) return false;
			if (!Objects.equals(tenderOffer, _that.getTenderOffer())) return false;
			if (!Objects.equals(tenderOfferEvents, _that.getTenderOfferEvents())) return false;
			if (!Objects.equals(compositionOfCombinedConsideration, _that.getCompositionOfCombinedConsideration())) return false;
			if (!Objects.equals(indexAdjustmentEvents, _that.getIndexAdjustmentEvents())) return false;
			if (!Objects.equals(additionalDisruptionEvents, _that.getAdditionalDisruptionEvents())) return false;
			if (!Objects.equals(failureToDeliver, _that.getFailureToDeliver())) return false;
			if (!Objects.equals(representations, _that.getRepresentations())) return false;
			if (!Objects.equals(nationalisationOrInsolvency, _that.getNationalisationOrInsolvency())) return false;
			if (!Objects.equals(delisting, _that.getDelisting())) return false;
			if (!Objects.equals(exchangeIdentifierModel, _that.getExchangeIdentifierModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mergerEvents != null ? mergerEvents.hashCode() : 0);
			_result = 31 * _result + (tenderOffer != null ? tenderOffer.hashCode() : 0);
			_result = 31 * _result + (tenderOfferEvents != null ? tenderOfferEvents.hashCode() : 0);
			_result = 31 * _result + (compositionOfCombinedConsideration != null ? compositionOfCombinedConsideration.hashCode() : 0);
			_result = 31 * _result + (indexAdjustmentEvents != null ? indexAdjustmentEvents.hashCode() : 0);
			_result = 31 * _result + (additionalDisruptionEvents != null ? additionalDisruptionEvents.hashCode() : 0);
			_result = 31 * _result + (failureToDeliver != null ? failureToDeliver.hashCode() : 0);
			_result = 31 * _result + (representations != null ? representations.hashCode() : 0);
			_result = 31 * _result + (nationalisationOrInsolvency != null ? nationalisationOrInsolvency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (delisting != null ? delisting.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exchangeIdentifierModel != null ? exchangeIdentifierModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtraordinaryEventsBuilder {" +
				"mergerEvents=" + this.mergerEvents + ", " +
				"tenderOffer=" + this.tenderOffer + ", " +
				"tenderOfferEvents=" + this.tenderOfferEvents + ", " +
				"compositionOfCombinedConsideration=" + this.compositionOfCombinedConsideration + ", " +
				"indexAdjustmentEvents=" + this.indexAdjustmentEvents + ", " +
				"additionalDisruptionEvents=" + this.additionalDisruptionEvents + ", " +
				"failureToDeliver=" + this.failureToDeliver + ", " +
				"representations=" + this.representations + ", " +
				"nationalisationOrInsolvency=" + this.nationalisationOrInsolvency + ", " +
				"delisting=" + this.delisting + ", " +
				"exchangeIdentifierModel=" + this.exchangeIdentifierModel +
			'}';
		}
	}
}
