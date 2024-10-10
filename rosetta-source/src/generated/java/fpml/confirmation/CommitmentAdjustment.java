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
import fpml.confirmation.AbstractFacilityEvent;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilder;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilderImpl;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventImpl;
import fpml.confirmation.AdjustmentType;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.CommitmentAdjustment;
import fpml.confirmation.CommitmentAdjustment.CommitmentAdjustmentBuilder;
import fpml.confirmation.CommitmentAdjustment.CommitmentAdjustmentBuilderImpl;
import fpml.confirmation.CommitmentAdjustment.CommitmentAdjustmentImpl;
import fpml.confirmation.CommitmentSchedule;
import fpml.confirmation.FacilityCommitment;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.meta.CommitmentAdjustmentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event defining a future change in facility commitment.
 * @version ${project.version}
 */
@RosettaDataType(value="CommitmentAdjustment", builder=CommitmentAdjustment.CommitmentAdjustmentBuilderImpl.class, version="${project.version}")
public interface CommitmentAdjustment extends AbstractFacilityEvent {

	CommitmentAdjustmentMeta metaData = new CommitmentAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines whether the lender has an option to accept or deny the commitment change.
	 */
	Boolean getRefusalAllowed();
	/**
	 * Defines whether the commitment adjustment is scheduled.
	 */
	Boolean getScheduled();
	/**
	 * Defines whether the commitment adjustment is related to a PIK.
	 */
	Boolean getPik();
	/**
	 * The global/lender commitment amount stated AFTER a commitment adjustment has taken place.
	 */
	FacilityCommitment getFacilityCommitment();
	/**
	 * Defines the type of adjustment applied - increase or decrease.
	 */
	AdjustmentType getAdjustment();
	/**
	 * The amortization schedule associated with the facility commitment.
	 */
	CommitmentSchedule getCommitmentSchedule();

	/*********************** Build Methods  ***********************/
	CommitmentAdjustment build();
	
	CommitmentAdjustment.CommitmentAdjustmentBuilder toBuilder();
	
	static CommitmentAdjustment.CommitmentAdjustmentBuilder builder() {
		return new CommitmentAdjustment.CommitmentAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommitmentAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommitmentAdjustment> getType() {
		return CommitmentAdjustment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.class, getLenderAndCashDetailsModel());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.class, getBusinessEventPartiesModel());
		processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
		processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.class, getFacilityReference());
		processor.processBasic(path.newSubPath("refusalAllowed"), Boolean.class, getRefusalAllowed(), this);
		processor.processBasic(path.newSubPath("scheduled"), Boolean.class, getScheduled(), this);
		processor.processBasic(path.newSubPath("pik"), Boolean.class, getPik(), this);
		processRosetta(path.newSubPath("facilityCommitment"), processor, FacilityCommitment.class, getFacilityCommitment());
		processRosetta(path.newSubPath("adjustment"), processor, AdjustmentType.class, getAdjustment());
		processRosetta(path.newSubPath("commitmentSchedule"), processor, CommitmentSchedule.class, getCommitmentSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommitmentAdjustmentBuilder extends CommitmentAdjustment, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		FacilityCommitment.FacilityCommitmentBuilder getOrCreateFacilityCommitment();
		FacilityCommitment.FacilityCommitmentBuilder getFacilityCommitment();
		AdjustmentType.AdjustmentTypeBuilder getOrCreateAdjustment();
		AdjustmentType.AdjustmentTypeBuilder getAdjustment();
		CommitmentSchedule.CommitmentScheduleBuilder getOrCreateCommitmentSchedule();
		CommitmentSchedule.CommitmentScheduleBuilder getCommitmentSchedule();
		CommitmentAdjustment.CommitmentAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		CommitmentAdjustment.CommitmentAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		CommitmentAdjustment.CommitmentAdjustmentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setComment(String comment);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setEffectiveDate(Date effectiveDate);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setFacilityReference(FacilityReference facilityReference);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setRefusalAllowed(Boolean refusalAllowed);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setScheduled(Boolean scheduled);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setPik(Boolean pik);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setFacilityCommitment(FacilityCommitment facilityCommitment);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setAdjustment(AdjustmentType adjustment);
		CommitmentAdjustment.CommitmentAdjustmentBuilder setCommitmentSchedule(CommitmentSchedule commitmentSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderAndCashDetailsModel"), processor, LenderAndCashDetailsModel.LenderAndCashDetailsModelBuilder.class, getLenderAndCashDetailsModel());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("businessEventPartiesModel"), processor, BusinessEventPartiesModel.BusinessEventPartiesModelBuilder.class, getBusinessEventPartiesModel());
			processor.processBasic(path.newSubPath("effectiveDate"), Date.class, getEffectiveDate(), this);
			processRosetta(path.newSubPath("facilityReference"), processor, FacilityReference.FacilityReferenceBuilder.class, getFacilityReference());
			processor.processBasic(path.newSubPath("refusalAllowed"), Boolean.class, getRefusalAllowed(), this);
			processor.processBasic(path.newSubPath("scheduled"), Boolean.class, getScheduled(), this);
			processor.processBasic(path.newSubPath("pik"), Boolean.class, getPik(), this);
			processRosetta(path.newSubPath("facilityCommitment"), processor, FacilityCommitment.FacilityCommitmentBuilder.class, getFacilityCommitment());
			processRosetta(path.newSubPath("adjustment"), processor, AdjustmentType.AdjustmentTypeBuilder.class, getAdjustment());
			processRosetta(path.newSubPath("commitmentSchedule"), processor, CommitmentSchedule.CommitmentScheduleBuilder.class, getCommitmentSchedule());
		}
		

		CommitmentAdjustment.CommitmentAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of CommitmentAdjustment  ***********************/
	class CommitmentAdjustmentImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements CommitmentAdjustment {
		private final Boolean refusalAllowed;
		private final Boolean scheduled;
		private final Boolean pik;
		private final FacilityCommitment facilityCommitment;
		private final AdjustmentType adjustment;
		private final CommitmentSchedule commitmentSchedule;
		
		protected CommitmentAdjustmentImpl(CommitmentAdjustment.CommitmentAdjustmentBuilder builder) {
			super(builder);
			this.refusalAllowed = builder.getRefusalAllowed();
			this.scheduled = builder.getScheduled();
			this.pik = builder.getPik();
			this.facilityCommitment = ofNullable(builder.getFacilityCommitment()).map(f->f.build()).orElse(null);
			this.adjustment = ofNullable(builder.getAdjustment()).map(f->f.build()).orElse(null);
			this.commitmentSchedule = ofNullable(builder.getCommitmentSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("refusalAllowed")
		public Boolean getRefusalAllowed() {
			return refusalAllowed;
		}
		
		@Override
		@RosettaAttribute("scheduled")
		public Boolean getScheduled() {
			return scheduled;
		}
		
		@Override
		@RosettaAttribute("pik")
		public Boolean getPik() {
			return pik;
		}
		
		@Override
		@RosettaAttribute("facilityCommitment")
		public FacilityCommitment getFacilityCommitment() {
			return facilityCommitment;
		}
		
		@Override
		@RosettaAttribute("adjustment")
		public AdjustmentType getAdjustment() {
			return adjustment;
		}
		
		@Override
		@RosettaAttribute("commitmentSchedule")
		public CommitmentSchedule getCommitmentSchedule() {
			return commitmentSchedule;
		}
		
		@Override
		public CommitmentAdjustment build() {
			return this;
		}
		
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder toBuilder() {
			CommitmentAdjustment.CommitmentAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommitmentAdjustment.CommitmentAdjustmentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRefusalAllowed()).ifPresent(builder::setRefusalAllowed);
			ofNullable(getScheduled()).ifPresent(builder::setScheduled);
			ofNullable(getPik()).ifPresent(builder::setPik);
			ofNullable(getFacilityCommitment()).ifPresent(builder::setFacilityCommitment);
			ofNullable(getAdjustment()).ifPresent(builder::setAdjustment);
			ofNullable(getCommitmentSchedule()).ifPresent(builder::setCommitmentSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommitmentAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(refusalAllowed, _that.getRefusalAllowed())) return false;
			if (!Objects.equals(scheduled, _that.getScheduled())) return false;
			if (!Objects.equals(pik, _that.getPik())) return false;
			if (!Objects.equals(facilityCommitment, _that.getFacilityCommitment())) return false;
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(commitmentSchedule, _that.getCommitmentSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (refusalAllowed != null ? refusalAllowed.hashCode() : 0);
			_result = 31 * _result + (scheduled != null ? scheduled.hashCode() : 0);
			_result = 31 * _result + (pik != null ? pik.hashCode() : 0);
			_result = 31 * _result + (facilityCommitment != null ? facilityCommitment.hashCode() : 0);
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (commitmentSchedule != null ? commitmentSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommitmentAdjustment {" +
				"refusalAllowed=" + this.refusalAllowed + ", " +
				"scheduled=" + this.scheduled + ", " +
				"pik=" + this.pik + ", " +
				"facilityCommitment=" + this.facilityCommitment + ", " +
				"adjustment=" + this.adjustment + ", " +
				"commitmentSchedule=" + this.commitmentSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommitmentAdjustment  ***********************/
	class CommitmentAdjustmentBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements CommitmentAdjustment.CommitmentAdjustmentBuilder {
	
		protected Boolean refusalAllowed;
		protected Boolean scheduled;
		protected Boolean pik;
		protected FacilityCommitment.FacilityCommitmentBuilder facilityCommitment;
		protected AdjustmentType.AdjustmentTypeBuilder adjustment;
		protected CommitmentSchedule.CommitmentScheduleBuilder commitmentSchedule;
	
		public CommitmentAdjustmentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("refusalAllowed")
		public Boolean getRefusalAllowed() {
			return refusalAllowed;
		}
		
		@Override
		@RosettaAttribute("scheduled")
		public Boolean getScheduled() {
			return scheduled;
		}
		
		@Override
		@RosettaAttribute("pik")
		public Boolean getPik() {
			return pik;
		}
		
		@Override
		@RosettaAttribute("facilityCommitment")
		public FacilityCommitment.FacilityCommitmentBuilder getFacilityCommitment() {
			return facilityCommitment;
		}
		
		@Override
		public FacilityCommitment.FacilityCommitmentBuilder getOrCreateFacilityCommitment() {
			FacilityCommitment.FacilityCommitmentBuilder result;
			if (facilityCommitment!=null) {
				result = facilityCommitment;
			}
			else {
				result = facilityCommitment = FacilityCommitment.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustment")
		public AdjustmentType.AdjustmentTypeBuilder getAdjustment() {
			return adjustment;
		}
		
		@Override
		public AdjustmentType.AdjustmentTypeBuilder getOrCreateAdjustment() {
			AdjustmentType.AdjustmentTypeBuilder result;
			if (adjustment!=null) {
				result = adjustment;
			}
			else {
				result = adjustment = AdjustmentType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commitmentSchedule")
		public CommitmentSchedule.CommitmentScheduleBuilder getCommitmentSchedule() {
			return commitmentSchedule;
		}
		
		@Override
		public CommitmentSchedule.CommitmentScheduleBuilder getOrCreateCommitmentSchedule() {
			CommitmentSchedule.CommitmentScheduleBuilder result;
			if (commitmentSchedule!=null) {
				result = commitmentSchedule;
			}
			else {
				result = commitmentSchedule = CommitmentSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public CommitmentAdjustment.CommitmentAdjustmentBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("parentEventIdentifier")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("refusalAllowed")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setRefusalAllowed(Boolean refusalAllowed) {
			this.refusalAllowed = refusalAllowed==null?null:refusalAllowed;
			return this;
		}
		@Override
		@RosettaAttribute("scheduled")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setScheduled(Boolean scheduled) {
			this.scheduled = scheduled==null?null:scheduled;
			return this;
		}
		@Override
		@RosettaAttribute("pik")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setPik(Boolean pik) {
			this.pik = pik==null?null:pik;
			return this;
		}
		@Override
		@RosettaAttribute("facilityCommitment")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setFacilityCommitment(FacilityCommitment facilityCommitment) {
			this.facilityCommitment = facilityCommitment==null?null:facilityCommitment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustment")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setAdjustment(AdjustmentType adjustment) {
			this.adjustment = adjustment==null?null:adjustment.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commitmentSchedule")
		public CommitmentAdjustment.CommitmentAdjustmentBuilder setCommitmentSchedule(CommitmentSchedule commitmentSchedule) {
			this.commitmentSchedule = commitmentSchedule==null?null:commitmentSchedule.toBuilder();
			return this;
		}
		
		@Override
		public CommitmentAdjustment build() {
			return new CommitmentAdjustment.CommitmentAdjustmentImpl(this);
		}
		
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder prune() {
			super.prune();
			if (facilityCommitment!=null && !facilityCommitment.prune().hasData()) facilityCommitment = null;
			if (adjustment!=null && !adjustment.prune().hasData()) adjustment = null;
			if (commitmentSchedule!=null && !commitmentSchedule.prune().hasData()) commitmentSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRefusalAllowed()!=null) return true;
			if (getScheduled()!=null) return true;
			if (getPik()!=null) return true;
			if (getFacilityCommitment()!=null && getFacilityCommitment().hasData()) return true;
			if (getAdjustment()!=null && getAdjustment().hasData()) return true;
			if (getCommitmentSchedule()!=null && getCommitmentSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommitmentAdjustment.CommitmentAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommitmentAdjustment.CommitmentAdjustmentBuilder o = (CommitmentAdjustment.CommitmentAdjustmentBuilder) other;
			
			merger.mergeRosetta(getFacilityCommitment(), o.getFacilityCommitment(), this::setFacilityCommitment);
			merger.mergeRosetta(getAdjustment(), o.getAdjustment(), this::setAdjustment);
			merger.mergeRosetta(getCommitmentSchedule(), o.getCommitmentSchedule(), this::setCommitmentSchedule);
			
			merger.mergeBasic(getRefusalAllowed(), o.getRefusalAllowed(), this::setRefusalAllowed);
			merger.mergeBasic(getScheduled(), o.getScheduled(), this::setScheduled);
			merger.mergeBasic(getPik(), o.getPik(), this::setPik);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommitmentAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(refusalAllowed, _that.getRefusalAllowed())) return false;
			if (!Objects.equals(scheduled, _that.getScheduled())) return false;
			if (!Objects.equals(pik, _that.getPik())) return false;
			if (!Objects.equals(facilityCommitment, _that.getFacilityCommitment())) return false;
			if (!Objects.equals(adjustment, _that.getAdjustment())) return false;
			if (!Objects.equals(commitmentSchedule, _that.getCommitmentSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (refusalAllowed != null ? refusalAllowed.hashCode() : 0);
			_result = 31 * _result + (scheduled != null ? scheduled.hashCode() : 0);
			_result = 31 * _result + (pik != null ? pik.hashCode() : 0);
			_result = 31 * _result + (facilityCommitment != null ? facilityCommitment.hashCode() : 0);
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			_result = 31 * _result + (commitmentSchedule != null ? commitmentSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommitmentAdjustmentBuilder {" +
				"refusalAllowed=" + this.refusalAllowed + ", " +
				"scheduled=" + this.scheduled + ", " +
				"pik=" + this.pik + ", " +
				"facilityCommitment=" + this.facilityCommitment + ", " +
				"adjustment=" + this.adjustment + ", " +
				"commitmentSchedule=" + this.commitmentSchedule +
			'}' + " " + super.toString();
		}
	}
}
