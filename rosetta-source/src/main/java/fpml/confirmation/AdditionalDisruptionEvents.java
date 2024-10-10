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
import fpml.confirmation.AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder;
import fpml.confirmation.AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilderImpl;
import fpml.confirmation.AdditionalDisruptionEvents.AdditionalDisruptionEventsImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.StockLoanModel;
import fpml.confirmation.meta.AdditionalDisruptionEventsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type for defining ISDA 2002 Equity Derivative Additional Disruption Events.
 * @version ${project.version}
 */
@RosettaDataType(value="AdditionalDisruptionEvents", builder=AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilderImpl.class, version="${project.version}")
public interface AdditionalDisruptionEvents extends RosettaModelObject {

	AdditionalDisruptionEventsMeta metaData = new AdditionalDisruptionEventsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If true, then change in law is applicable.
	 */
	Boolean getChangeInLaw();
	/**
	 * Where the underlying is shares and the transaction is physically settled, then, if true, a failure to deliver the shares on the settlement date will not be an event of default for the purposes of the master agreement.
	 */
	Boolean getFailureToDeliver();
	/**
	 * If true, then insolvency filing is applicable.
	 */
	Boolean getInsolvencyFiling();
	/**
	 * If true, then hedging disruption is applicable.
	 */
	Boolean getHedgingDisruption();
	StockLoanModel getStockLoanModel();
	/**
	 * If true, then increased cost of hedging is applicable.
	 */
	Boolean getIncreasedCostOfHedging();
	/**
	 * A reference to the party which determines additional disruption events.
	 */
	PartyReference getDeterminingPartyReference();
	/**
	 * If true, then foreign ownership event is applicable.
	 */
	Boolean getForeignOwnershipEvent();

	/*********************** Build Methods  ***********************/
	AdditionalDisruptionEvents build();
	
	AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder toBuilder();
	
	static AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder builder() {
		return new AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdditionalDisruptionEvents> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdditionalDisruptionEvents> getType() {
		return AdditionalDisruptionEvents.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("changeInLaw"), Boolean.class, getChangeInLaw(), this);
		processor.processBasic(path.newSubPath("failureToDeliver"), Boolean.class, getFailureToDeliver(), this);
		processor.processBasic(path.newSubPath("insolvencyFiling"), Boolean.class, getInsolvencyFiling(), this);
		processor.processBasic(path.newSubPath("hedgingDisruption"), Boolean.class, getHedgingDisruption(), this);
		processRosetta(path.newSubPath("stockLoanModel"), processor, StockLoanModel.class, getStockLoanModel());
		processor.processBasic(path.newSubPath("increasedCostOfHedging"), Boolean.class, getIncreasedCostOfHedging(), this);
		processRosetta(path.newSubPath("determiningPartyReference"), processor, PartyReference.class, getDeterminingPartyReference());
		processor.processBasic(path.newSubPath("foreignOwnershipEvent"), Boolean.class, getForeignOwnershipEvent(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdditionalDisruptionEventsBuilder extends AdditionalDisruptionEvents, RosettaModelObjectBuilder {
		StockLoanModel.StockLoanModelBuilder getOrCreateStockLoanModel();
		StockLoanModel.StockLoanModelBuilder getStockLoanModel();
		PartyReference.PartyReferenceBuilder getOrCreateDeterminingPartyReference();
		PartyReference.PartyReferenceBuilder getDeterminingPartyReference();
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setChangeInLaw(Boolean changeInLaw);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setFailureToDeliver(Boolean failureToDeliver);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setInsolvencyFiling(Boolean insolvencyFiling);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setHedgingDisruption(Boolean hedgingDisruption);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setStockLoanModel(StockLoanModel stockLoanModel);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setIncreasedCostOfHedging(Boolean increasedCostOfHedging);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setDeterminingPartyReference(PartyReference determiningPartyReference);
		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setForeignOwnershipEvent(Boolean foreignOwnershipEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("changeInLaw"), Boolean.class, getChangeInLaw(), this);
			processor.processBasic(path.newSubPath("failureToDeliver"), Boolean.class, getFailureToDeliver(), this);
			processor.processBasic(path.newSubPath("insolvencyFiling"), Boolean.class, getInsolvencyFiling(), this);
			processor.processBasic(path.newSubPath("hedgingDisruption"), Boolean.class, getHedgingDisruption(), this);
			processRosetta(path.newSubPath("stockLoanModel"), processor, StockLoanModel.StockLoanModelBuilder.class, getStockLoanModel());
			processor.processBasic(path.newSubPath("increasedCostOfHedging"), Boolean.class, getIncreasedCostOfHedging(), this);
			processRosetta(path.newSubPath("determiningPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getDeterminingPartyReference());
			processor.processBasic(path.newSubPath("foreignOwnershipEvent"), Boolean.class, getForeignOwnershipEvent(), this);
		}
		

		AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder prune();
	}

	/*********************** Immutable Implementation of AdditionalDisruptionEvents  ***********************/
	class AdditionalDisruptionEventsImpl implements AdditionalDisruptionEvents {
		private final Boolean changeInLaw;
		private final Boolean failureToDeliver;
		private final Boolean insolvencyFiling;
		private final Boolean hedgingDisruption;
		private final StockLoanModel stockLoanModel;
		private final Boolean increasedCostOfHedging;
		private final PartyReference determiningPartyReference;
		private final Boolean foreignOwnershipEvent;
		
		protected AdditionalDisruptionEventsImpl(AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder builder) {
			this.changeInLaw = builder.getChangeInLaw();
			this.failureToDeliver = builder.getFailureToDeliver();
			this.insolvencyFiling = builder.getInsolvencyFiling();
			this.hedgingDisruption = builder.getHedgingDisruption();
			this.stockLoanModel = ofNullable(builder.getStockLoanModel()).map(f->f.build()).orElse(null);
			this.increasedCostOfHedging = builder.getIncreasedCostOfHedging();
			this.determiningPartyReference = ofNullable(builder.getDeterminingPartyReference()).map(f->f.build()).orElse(null);
			this.foreignOwnershipEvent = builder.getForeignOwnershipEvent();
		}
		
		@Override
		@RosettaAttribute("changeInLaw")
		public Boolean getChangeInLaw() {
			return changeInLaw;
		}
		
		@Override
		@RosettaAttribute("failureToDeliver")
		public Boolean getFailureToDeliver() {
			return failureToDeliver;
		}
		
		@Override
		@RosettaAttribute("insolvencyFiling")
		public Boolean getInsolvencyFiling() {
			return insolvencyFiling;
		}
		
		@Override
		@RosettaAttribute("hedgingDisruption")
		public Boolean getHedgingDisruption() {
			return hedgingDisruption;
		}
		
		@Override
		@RosettaAttribute("stockLoanModel")
		public StockLoanModel getStockLoanModel() {
			return stockLoanModel;
		}
		
		@Override
		@RosettaAttribute("increasedCostOfHedging")
		public Boolean getIncreasedCostOfHedging() {
			return increasedCostOfHedging;
		}
		
		@Override
		@RosettaAttribute("determiningPartyReference")
		public PartyReference getDeterminingPartyReference() {
			return determiningPartyReference;
		}
		
		@Override
		@RosettaAttribute("foreignOwnershipEvent")
		public Boolean getForeignOwnershipEvent() {
			return foreignOwnershipEvent;
		}
		
		@Override
		public AdditionalDisruptionEvents build() {
			return this;
		}
		
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder toBuilder() {
			AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder builder) {
			ofNullable(getChangeInLaw()).ifPresent(builder::setChangeInLaw);
			ofNullable(getFailureToDeliver()).ifPresent(builder::setFailureToDeliver);
			ofNullable(getInsolvencyFiling()).ifPresent(builder::setInsolvencyFiling);
			ofNullable(getHedgingDisruption()).ifPresent(builder::setHedgingDisruption);
			ofNullable(getStockLoanModel()).ifPresent(builder::setStockLoanModel);
			ofNullable(getIncreasedCostOfHedging()).ifPresent(builder::setIncreasedCostOfHedging);
			ofNullable(getDeterminingPartyReference()).ifPresent(builder::setDeterminingPartyReference);
			ofNullable(getForeignOwnershipEvent()).ifPresent(builder::setForeignOwnershipEvent);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalDisruptionEvents _that = getType().cast(o);
		
			if (!Objects.equals(changeInLaw, _that.getChangeInLaw())) return false;
			if (!Objects.equals(failureToDeliver, _that.getFailureToDeliver())) return false;
			if (!Objects.equals(insolvencyFiling, _that.getInsolvencyFiling())) return false;
			if (!Objects.equals(hedgingDisruption, _that.getHedgingDisruption())) return false;
			if (!Objects.equals(stockLoanModel, _that.getStockLoanModel())) return false;
			if (!Objects.equals(increasedCostOfHedging, _that.getIncreasedCostOfHedging())) return false;
			if (!Objects.equals(determiningPartyReference, _that.getDeterminingPartyReference())) return false;
			if (!Objects.equals(foreignOwnershipEvent, _that.getForeignOwnershipEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (changeInLaw != null ? changeInLaw.hashCode() : 0);
			_result = 31 * _result + (failureToDeliver != null ? failureToDeliver.hashCode() : 0);
			_result = 31 * _result + (insolvencyFiling != null ? insolvencyFiling.hashCode() : 0);
			_result = 31 * _result + (hedgingDisruption != null ? hedgingDisruption.hashCode() : 0);
			_result = 31 * _result + (stockLoanModel != null ? stockLoanModel.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfHedging != null ? increasedCostOfHedging.hashCode() : 0);
			_result = 31 * _result + (determiningPartyReference != null ? determiningPartyReference.hashCode() : 0);
			_result = 31 * _result + (foreignOwnershipEvent != null ? foreignOwnershipEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalDisruptionEvents {" +
				"changeInLaw=" + this.changeInLaw + ", " +
				"failureToDeliver=" + this.failureToDeliver + ", " +
				"insolvencyFiling=" + this.insolvencyFiling + ", " +
				"hedgingDisruption=" + this.hedgingDisruption + ", " +
				"stockLoanModel=" + this.stockLoanModel + ", " +
				"increasedCostOfHedging=" + this.increasedCostOfHedging + ", " +
				"determiningPartyReference=" + this.determiningPartyReference + ", " +
				"foreignOwnershipEvent=" + this.foreignOwnershipEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of AdditionalDisruptionEvents  ***********************/
	class AdditionalDisruptionEventsBuilderImpl implements AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder {
	
		protected Boolean changeInLaw;
		protected Boolean failureToDeliver;
		protected Boolean insolvencyFiling;
		protected Boolean hedgingDisruption;
		protected StockLoanModel.StockLoanModelBuilder stockLoanModel;
		protected Boolean increasedCostOfHedging;
		protected PartyReference.PartyReferenceBuilder determiningPartyReference;
		protected Boolean foreignOwnershipEvent;
	
		public AdditionalDisruptionEventsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("changeInLaw")
		public Boolean getChangeInLaw() {
			return changeInLaw;
		}
		
		@Override
		@RosettaAttribute("failureToDeliver")
		public Boolean getFailureToDeliver() {
			return failureToDeliver;
		}
		
		@Override
		@RosettaAttribute("insolvencyFiling")
		public Boolean getInsolvencyFiling() {
			return insolvencyFiling;
		}
		
		@Override
		@RosettaAttribute("hedgingDisruption")
		public Boolean getHedgingDisruption() {
			return hedgingDisruption;
		}
		
		@Override
		@RosettaAttribute("stockLoanModel")
		public StockLoanModel.StockLoanModelBuilder getStockLoanModel() {
			return stockLoanModel;
		}
		
		@Override
		public StockLoanModel.StockLoanModelBuilder getOrCreateStockLoanModel() {
			StockLoanModel.StockLoanModelBuilder result;
			if (stockLoanModel!=null) {
				result = stockLoanModel;
			}
			else {
				result = stockLoanModel = StockLoanModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("increasedCostOfHedging")
		public Boolean getIncreasedCostOfHedging() {
			return increasedCostOfHedging;
		}
		
		@Override
		@RosettaAttribute("determiningPartyReference")
		public PartyReference.PartyReferenceBuilder getDeterminingPartyReference() {
			return determiningPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateDeterminingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (determiningPartyReference!=null) {
				result = determiningPartyReference;
			}
			else {
				result = determiningPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("foreignOwnershipEvent")
		public Boolean getForeignOwnershipEvent() {
			return foreignOwnershipEvent;
		}
		
		@Override
		@RosettaAttribute("changeInLaw")
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setChangeInLaw(Boolean changeInLaw) {
			this.changeInLaw = changeInLaw==null?null:changeInLaw;
			return this;
		}
		@Override
		@RosettaAttribute("failureToDeliver")
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setFailureToDeliver(Boolean failureToDeliver) {
			this.failureToDeliver = failureToDeliver==null?null:failureToDeliver;
			return this;
		}
		@Override
		@RosettaAttribute("insolvencyFiling")
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setInsolvencyFiling(Boolean insolvencyFiling) {
			this.insolvencyFiling = insolvencyFiling==null?null:insolvencyFiling;
			return this;
		}
		@Override
		@RosettaAttribute("hedgingDisruption")
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setHedgingDisruption(Boolean hedgingDisruption) {
			this.hedgingDisruption = hedgingDisruption==null?null:hedgingDisruption;
			return this;
		}
		@Override
		@RosettaAttribute("stockLoanModel")
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setStockLoanModel(StockLoanModel stockLoanModel) {
			this.stockLoanModel = stockLoanModel==null?null:stockLoanModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("increasedCostOfHedging")
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setIncreasedCostOfHedging(Boolean increasedCostOfHedging) {
			this.increasedCostOfHedging = increasedCostOfHedging==null?null:increasedCostOfHedging;
			return this;
		}
		@Override
		@RosettaAttribute("determiningPartyReference")
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setDeterminingPartyReference(PartyReference determiningPartyReference) {
			this.determiningPartyReference = determiningPartyReference==null?null:determiningPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("foreignOwnershipEvent")
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder setForeignOwnershipEvent(Boolean foreignOwnershipEvent) {
			this.foreignOwnershipEvent = foreignOwnershipEvent==null?null:foreignOwnershipEvent;
			return this;
		}
		
		@Override
		public AdditionalDisruptionEvents build() {
			return new AdditionalDisruptionEvents.AdditionalDisruptionEventsImpl(this);
		}
		
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder prune() {
			if (stockLoanModel!=null && !stockLoanModel.prune().hasData()) stockLoanModel = null;
			if (determiningPartyReference!=null && !determiningPartyReference.prune().hasData()) determiningPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getChangeInLaw()!=null) return true;
			if (getFailureToDeliver()!=null) return true;
			if (getInsolvencyFiling()!=null) return true;
			if (getHedgingDisruption()!=null) return true;
			if (getStockLoanModel()!=null && getStockLoanModel().hasData()) return true;
			if (getIncreasedCostOfHedging()!=null) return true;
			if (getDeterminingPartyReference()!=null && getDeterminingPartyReference().hasData()) return true;
			if (getForeignOwnershipEvent()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder o = (AdditionalDisruptionEvents.AdditionalDisruptionEventsBuilder) other;
			
			merger.mergeRosetta(getStockLoanModel(), o.getStockLoanModel(), this::setStockLoanModel);
			merger.mergeRosetta(getDeterminingPartyReference(), o.getDeterminingPartyReference(), this::setDeterminingPartyReference);
			
			merger.mergeBasic(getChangeInLaw(), o.getChangeInLaw(), this::setChangeInLaw);
			merger.mergeBasic(getFailureToDeliver(), o.getFailureToDeliver(), this::setFailureToDeliver);
			merger.mergeBasic(getInsolvencyFiling(), o.getInsolvencyFiling(), this::setInsolvencyFiling);
			merger.mergeBasic(getHedgingDisruption(), o.getHedgingDisruption(), this::setHedgingDisruption);
			merger.mergeBasic(getIncreasedCostOfHedging(), o.getIncreasedCostOfHedging(), this::setIncreasedCostOfHedging);
			merger.mergeBasic(getForeignOwnershipEvent(), o.getForeignOwnershipEvent(), this::setForeignOwnershipEvent);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalDisruptionEvents _that = getType().cast(o);
		
			if (!Objects.equals(changeInLaw, _that.getChangeInLaw())) return false;
			if (!Objects.equals(failureToDeliver, _that.getFailureToDeliver())) return false;
			if (!Objects.equals(insolvencyFiling, _that.getInsolvencyFiling())) return false;
			if (!Objects.equals(hedgingDisruption, _that.getHedgingDisruption())) return false;
			if (!Objects.equals(stockLoanModel, _that.getStockLoanModel())) return false;
			if (!Objects.equals(increasedCostOfHedging, _that.getIncreasedCostOfHedging())) return false;
			if (!Objects.equals(determiningPartyReference, _that.getDeterminingPartyReference())) return false;
			if (!Objects.equals(foreignOwnershipEvent, _that.getForeignOwnershipEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (changeInLaw != null ? changeInLaw.hashCode() : 0);
			_result = 31 * _result + (failureToDeliver != null ? failureToDeliver.hashCode() : 0);
			_result = 31 * _result + (insolvencyFiling != null ? insolvencyFiling.hashCode() : 0);
			_result = 31 * _result + (hedgingDisruption != null ? hedgingDisruption.hashCode() : 0);
			_result = 31 * _result + (stockLoanModel != null ? stockLoanModel.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfHedging != null ? increasedCostOfHedging.hashCode() : 0);
			_result = 31 * _result + (determiningPartyReference != null ? determiningPartyReference.hashCode() : 0);
			_result = 31 * _result + (foreignOwnershipEvent != null ? foreignOwnershipEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalDisruptionEventsBuilder {" +
				"changeInLaw=" + this.changeInLaw + ", " +
				"failureToDeliver=" + this.failureToDeliver + ", " +
				"insolvencyFiling=" + this.insolvencyFiling + ", " +
				"hedgingDisruption=" + this.hedgingDisruption + ", " +
				"stockLoanModel=" + this.stockLoanModel + ", " +
				"increasedCostOfHedging=" + this.increasedCostOfHedging + ", " +
				"determiningPartyReference=" + this.determiningPartyReference + ", " +
				"foreignOwnershipEvent=" + this.foreignOwnershipEvent +
			'}';
		}
	}
}
