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
import fpml.confirmation.CreditCurveCharacteristicsModel;
import fpml.confirmation.CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder;
import fpml.confirmation.CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilderImpl;
import fpml.confirmation.CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelImpl;
import fpml.confirmation.CreditEntityModel;
import fpml.confirmation.CreditEvents;
import fpml.confirmation.CreditSeniority;
import fpml.confirmation.Currency;
import fpml.confirmation.DeliverableObligations;
import fpml.confirmation.Obligations;
import fpml.confirmation.meta.CreditCurveCharacteristicsModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The set of characterstics that describe the outputs of a credit curve.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CreditCurveCharacteristicsModel", builder=CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CreditCurveCharacteristicsModel extends RosettaModelObject {

	CreditCurveCharacteristicsModelMeta metaData = new CreditCurveCharacteristicsModelMeta();

	/*********************** Getter Methods  ***********************/
	CreditEntityModel getCreditEntityModel();
	/**
	 * The material credit event.
	 */
	CreditEvents getCreditEvents();
	/**
	 * The level of seniority of the deliverable obligation.
	 */
	CreditSeniority getSeniority();
	/**
	 * Whether the deliverable obligation is secured or unsecured.
	 */
	Boolean getSecured();
	/**
	 * The currency of denomination of the deliverable obligation.
	 */
	Currency getObligationCurrency();
	/**
	 * The underlying obligations of the reference entity on which you are buying or selling protection
	 */
	Obligations getObligations();
	/**
	 * What sort of obligation may be delivered in the event of the credit event. ISDA 2003 Term: Obligation Category/Deliverable Obligation Category
	 */
	DeliverableObligations getDeliverableObligations();

	/*********************** Build Methods  ***********************/
	CreditCurveCharacteristicsModel build();
	
	CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder toBuilder();
	
	static CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder builder() {
		return new CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditCurveCharacteristicsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditCurveCharacteristicsModel> getType() {
		return CreditCurveCharacteristicsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("creditEntityModel"), processor, CreditEntityModel.class, getCreditEntityModel());
		processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.class, getCreditEvents());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
		processor.processBasic(path.newSubPath("secured"), Boolean.class, getSecured(), this);
		processRosetta(path.newSubPath("obligationCurrency"), processor, Currency.class, getObligationCurrency());
		processRosetta(path.newSubPath("obligations"), processor, Obligations.class, getObligations());
		processRosetta(path.newSubPath("deliverableObligations"), processor, DeliverableObligations.class, getDeliverableObligations());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditCurveCharacteristicsModelBuilder extends CreditCurveCharacteristicsModel, RosettaModelObjectBuilder {
		CreditEntityModel.CreditEntityModelBuilder getOrCreateCreditEntityModel();
		CreditEntityModel.CreditEntityModelBuilder getCreditEntityModel();
		CreditEvents.CreditEventsBuilder getOrCreateCreditEvents();
		CreditEvents.CreditEventsBuilder getCreditEvents();
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		Currency.CurrencyBuilder getOrCreateObligationCurrency();
		Currency.CurrencyBuilder getObligationCurrency();
		Obligations.ObligationsBuilder getOrCreateObligations();
		Obligations.ObligationsBuilder getObligations();
		DeliverableObligations.DeliverableObligationsBuilder getOrCreateDeliverableObligations();
		DeliverableObligations.DeliverableObligationsBuilder getDeliverableObligations();
		CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setCreditEntityModel(CreditEntityModel creditEntityModel);
		CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setCreditEvents(CreditEvents creditEvents);
		CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setSeniority(CreditSeniority seniority);
		CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setSecured(Boolean secured);
		CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setObligationCurrency(Currency obligationCurrency);
		CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setObligations(Obligations obligations);
		CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setDeliverableObligations(DeliverableObligations deliverableObligations);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("creditEntityModel"), processor, CreditEntityModel.CreditEntityModelBuilder.class, getCreditEntityModel());
			processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.CreditEventsBuilder.class, getCreditEvents());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
			processor.processBasic(path.newSubPath("secured"), Boolean.class, getSecured(), this);
			processRosetta(path.newSubPath("obligationCurrency"), processor, Currency.CurrencyBuilder.class, getObligationCurrency());
			processRosetta(path.newSubPath("obligations"), processor, Obligations.ObligationsBuilder.class, getObligations());
			processRosetta(path.newSubPath("deliverableObligations"), processor, DeliverableObligations.DeliverableObligationsBuilder.class, getDeliverableObligations());
		}
		

		CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder prune();
	}

	/*********************** Immutable Implementation of CreditCurveCharacteristicsModel  ***********************/
	class CreditCurveCharacteristicsModelImpl implements CreditCurveCharacteristicsModel {
		private final CreditEntityModel creditEntityModel;
		private final CreditEvents creditEvents;
		private final CreditSeniority seniority;
		private final Boolean secured;
		private final Currency obligationCurrency;
		private final Obligations obligations;
		private final DeliverableObligations deliverableObligations;
		
		protected CreditCurveCharacteristicsModelImpl(CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder builder) {
			this.creditEntityModel = ofNullable(builder.getCreditEntityModel()).map(f->f.build()).orElse(null);
			this.creditEvents = ofNullable(builder.getCreditEvents()).map(f->f.build()).orElse(null);
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
			this.secured = builder.getSecured();
			this.obligationCurrency = ofNullable(builder.getObligationCurrency()).map(f->f.build()).orElse(null);
			this.obligations = ofNullable(builder.getObligations()).map(f->f.build()).orElse(null);
			this.deliverableObligations = ofNullable(builder.getDeliverableObligations()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditEntityModel")
		public CreditEntityModel getCreditEntityModel() {
			return creditEntityModel;
		}
		
		@Override
		@RosettaAttribute("creditEvents")
		public CreditEvents getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		@RosettaAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		@RosettaAttribute("secured")
		public Boolean getSecured() {
			return secured;
		}
		
		@Override
		@RosettaAttribute("obligationCurrency")
		public Currency getObligationCurrency() {
			return obligationCurrency;
		}
		
		@Override
		@RosettaAttribute("obligations")
		public Obligations getObligations() {
			return obligations;
		}
		
		@Override
		@RosettaAttribute("deliverableObligations")
		public DeliverableObligations getDeliverableObligations() {
			return deliverableObligations;
		}
		
		@Override
		public CreditCurveCharacteristicsModel build() {
			return this;
		}
		
		@Override
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder toBuilder() {
			CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder builder) {
			ofNullable(getCreditEntityModel()).ifPresent(builder::setCreditEntityModel);
			ofNullable(getCreditEvents()).ifPresent(builder::setCreditEvents);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
			ofNullable(getSecured()).ifPresent(builder::setSecured);
			ofNullable(getObligationCurrency()).ifPresent(builder::setObligationCurrency);
			ofNullable(getObligations()).ifPresent(builder::setObligations);
			ofNullable(getDeliverableObligations()).ifPresent(builder::setDeliverableObligations);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditCurveCharacteristicsModel _that = getType().cast(o);
		
			if (!Objects.equals(creditEntityModel, _that.getCreditEntityModel())) return false;
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(secured, _that.getSecured())) return false;
			if (!Objects.equals(obligationCurrency, _that.getObligationCurrency())) return false;
			if (!Objects.equals(obligations, _that.getObligations())) return false;
			if (!Objects.equals(deliverableObligations, _that.getDeliverableObligations())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEntityModel != null ? creditEntityModel.hashCode() : 0);
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (secured != null ? secured.hashCode() : 0);
			_result = 31 * _result + (obligationCurrency != null ? obligationCurrency.hashCode() : 0);
			_result = 31 * _result + (obligations != null ? obligations.hashCode() : 0);
			_result = 31 * _result + (deliverableObligations != null ? deliverableObligations.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditCurveCharacteristicsModel {" +
				"creditEntityModel=" + this.creditEntityModel + ", " +
				"creditEvents=" + this.creditEvents + ", " +
				"seniority=" + this.seniority + ", " +
				"secured=" + this.secured + ", " +
				"obligationCurrency=" + this.obligationCurrency + ", " +
				"obligations=" + this.obligations + ", " +
				"deliverableObligations=" + this.deliverableObligations +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditCurveCharacteristicsModel  ***********************/
	class CreditCurveCharacteristicsModelBuilderImpl implements CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder {
	
		protected CreditEntityModel.CreditEntityModelBuilder creditEntityModel;
		protected CreditEvents.CreditEventsBuilder creditEvents;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
		protected Boolean secured;
		protected Currency.CurrencyBuilder obligationCurrency;
		protected Obligations.ObligationsBuilder obligations;
		protected DeliverableObligations.DeliverableObligationsBuilder deliverableObligations;
	
		public CreditCurveCharacteristicsModelBuilderImpl() {
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
		@RosettaAttribute("creditEvents")
		public CreditEvents.CreditEventsBuilder getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder getOrCreateCreditEvents() {
			CreditEvents.CreditEventsBuilder result;
			if (creditEvents!=null) {
				result = creditEvents;
			}
			else {
				result = creditEvents = CreditEvents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seniority")
		public CreditSeniority.CreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority() {
			CreditSeniority.CreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = CreditSeniority.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secured")
		public Boolean getSecured() {
			return secured;
		}
		
		@Override
		@RosettaAttribute("obligationCurrency")
		public Currency.CurrencyBuilder getObligationCurrency() {
			return obligationCurrency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateObligationCurrency() {
			Currency.CurrencyBuilder result;
			if (obligationCurrency!=null) {
				result = obligationCurrency;
			}
			else {
				result = obligationCurrency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("obligations")
		public Obligations.ObligationsBuilder getObligations() {
			return obligations;
		}
		
		@Override
		public Obligations.ObligationsBuilder getOrCreateObligations() {
			Obligations.ObligationsBuilder result;
			if (obligations!=null) {
				result = obligations;
			}
			else {
				result = obligations = Obligations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliverableObligations")
		public DeliverableObligations.DeliverableObligationsBuilder getDeliverableObligations() {
			return deliverableObligations;
		}
		
		@Override
		public DeliverableObligations.DeliverableObligationsBuilder getOrCreateDeliverableObligations() {
			DeliverableObligations.DeliverableObligationsBuilder result;
			if (deliverableObligations!=null) {
				result = deliverableObligations;
			}
			else {
				result = deliverableObligations = DeliverableObligations.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEntityModel")
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setCreditEntityModel(CreditEntityModel creditEntityModel) {
			this.creditEntityModel = creditEntityModel==null?null:creditEntityModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditEvents")
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setCreditEvents(CreditEvents creditEvents) {
			this.creditEvents = creditEvents==null?null:creditEvents.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("seniority")
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setSeniority(CreditSeniority seniority) {
			this.seniority = seniority==null?null:seniority.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("secured")
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setSecured(Boolean secured) {
			this.secured = secured==null?null:secured;
			return this;
		}
		@Override
		@RosettaAttribute("obligationCurrency")
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setObligationCurrency(Currency obligationCurrency) {
			this.obligationCurrency = obligationCurrency==null?null:obligationCurrency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("obligations")
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setObligations(Obligations obligations) {
			this.obligations = obligations==null?null:obligations.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("deliverableObligations")
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder setDeliverableObligations(DeliverableObligations deliverableObligations) {
			this.deliverableObligations = deliverableObligations==null?null:deliverableObligations.toBuilder();
			return this;
		}
		
		@Override
		public CreditCurveCharacteristicsModel build() {
			return new CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelImpl(this);
		}
		
		@Override
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder prune() {
			if (creditEntityModel!=null && !creditEntityModel.prune().hasData()) creditEntityModel = null;
			if (creditEvents!=null && !creditEvents.prune().hasData()) creditEvents = null;
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
			if (obligationCurrency!=null && !obligationCurrency.prune().hasData()) obligationCurrency = null;
			if (obligations!=null && !obligations.prune().hasData()) obligations = null;
			if (deliverableObligations!=null && !deliverableObligations.prune().hasData()) deliverableObligations = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditEntityModel()!=null && getCreditEntityModel().hasData()) return true;
			if (getCreditEvents()!=null && getCreditEvents().hasData()) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			if (getSecured()!=null) return true;
			if (getObligationCurrency()!=null && getObligationCurrency().hasData()) return true;
			if (getObligations()!=null && getObligations().hasData()) return true;
			if (getDeliverableObligations()!=null && getDeliverableObligations().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder o = (CreditCurveCharacteristicsModel.CreditCurveCharacteristicsModelBuilder) other;
			
			merger.mergeRosetta(getCreditEntityModel(), o.getCreditEntityModel(), this::setCreditEntityModel);
			merger.mergeRosetta(getCreditEvents(), o.getCreditEvents(), this::setCreditEvents);
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			merger.mergeRosetta(getObligationCurrency(), o.getObligationCurrency(), this::setObligationCurrency);
			merger.mergeRosetta(getObligations(), o.getObligations(), this::setObligations);
			merger.mergeRosetta(getDeliverableObligations(), o.getDeliverableObligations(), this::setDeliverableObligations);
			
			merger.mergeBasic(getSecured(), o.getSecured(), this::setSecured);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditCurveCharacteristicsModel _that = getType().cast(o);
		
			if (!Objects.equals(creditEntityModel, _that.getCreditEntityModel())) return false;
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			if (!Objects.equals(secured, _that.getSecured())) return false;
			if (!Objects.equals(obligationCurrency, _that.getObligationCurrency())) return false;
			if (!Objects.equals(obligations, _that.getObligations())) return false;
			if (!Objects.equals(deliverableObligations, _that.getDeliverableObligations())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEntityModel != null ? creditEntityModel.hashCode() : 0);
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			_result = 31 * _result + (secured != null ? secured.hashCode() : 0);
			_result = 31 * _result + (obligationCurrency != null ? obligationCurrency.hashCode() : 0);
			_result = 31 * _result + (obligations != null ? obligations.hashCode() : 0);
			_result = 31 * _result + (deliverableObligations != null ? deliverableObligations.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditCurveCharacteristicsModelBuilder {" +
				"creditEntityModel=" + this.creditEntityModel + ", " +
				"creditEvents=" + this.creditEvents + ", " +
				"seniority=" + this.seniority + ", " +
				"secured=" + this.secured + ", " +
				"obligationCurrency=" + this.obligationCurrency + ", " +
				"obligations=" + this.obligations + ", " +
				"deliverableObligations=" + this.deliverableObligations +
			'}';
		}
	}
}
