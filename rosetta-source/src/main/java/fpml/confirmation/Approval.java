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
import fpml.confirmation.Approval;
import fpml.confirmation.Approval.ApprovalBuilder;
import fpml.confirmation.Approval.ApprovalBuilderImpl;
import fpml.confirmation.Approval.ApprovalImpl;
import fpml.confirmation.ApprovalId;
import fpml.confirmation.ApprovalType;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PersonId;
import fpml.confirmation.meta.ApprovalMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A specific approval state in the workflow.
 * @version ${project.version}
 */
@RosettaDataType(value="Approval", builder=Approval.ApprovalBuilderImpl.class, version="${project.version}")
public interface Approval extends RosettaModelObject {

	ApprovalMeta metaData = new ApprovalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of approval (e.g. &quot;pre-clearing credit&quot;).
	 */
	ApprovalType getType_();
	/**
	 * The current state of approval (.e.g preapproved, pending approval, etc.)
	 */
	String getStatus();
	/**
	 * The full name or identifiying ID of the relevant approver.
	 */
	PersonId getApprover();
	/**
	 * A pointer style reference to a party defined elsewhere in the document. The party referenced has approved the specified item (e.g. trade or allocation).
	 */
	PartyReference getApprovingPartyReference();
	/**
	 * A pointer style reference to a party defined elsewhere in the document. The party referenced was approved for the specified item (e.g. trade or allocation) by the approving party (if specified).
	 */
	PartyReference getApprovedPartyReference();
	/**
	 * An identifer for a specific appoval, to allow the approval to be identified and tracked.
	 */
	ApprovalId getApprovalId();

	/*********************** Build Methods  ***********************/
	Approval build();
	
	Approval.ApprovalBuilder toBuilder();
	
	static Approval.ApprovalBuilder builder() {
		return new Approval.ApprovalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Approval> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Approval> getType() {
		return Approval.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("type"), processor, ApprovalType.class, getType_());
		processor.processBasic(path.newSubPath("status"), String.class, getStatus(), this);
		processRosetta(path.newSubPath("approver"), processor, PersonId.class, getApprover());
		processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.class, getApprovingPartyReference());
		processRosetta(path.newSubPath("approvedPartyReference"), processor, PartyReference.class, getApprovedPartyReference());
		processRosetta(path.newSubPath("approvalId"), processor, ApprovalId.class, getApprovalId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApprovalBuilder extends Approval, RosettaModelObjectBuilder {
		ApprovalType.ApprovalTypeBuilder getOrCreateType();
		ApprovalType.ApprovalTypeBuilder getType_();
		PersonId.PersonIdBuilder getOrCreateApprover();
		PersonId.PersonIdBuilder getApprover();
		PartyReference.PartyReferenceBuilder getOrCreateApprovingPartyReference();
		PartyReference.PartyReferenceBuilder getApprovingPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateApprovedPartyReference();
		PartyReference.PartyReferenceBuilder getApprovedPartyReference();
		ApprovalId.ApprovalIdBuilder getOrCreateApprovalId();
		ApprovalId.ApprovalIdBuilder getApprovalId();
		Approval.ApprovalBuilder setType(ApprovalType type);
		Approval.ApprovalBuilder setStatus(String status);
		Approval.ApprovalBuilder setApprover(PersonId approver);
		Approval.ApprovalBuilder setApprovingPartyReference(PartyReference approvingPartyReference);
		Approval.ApprovalBuilder setApprovedPartyReference(PartyReference approvedPartyReference);
		Approval.ApprovalBuilder setApprovalId(ApprovalId approvalId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("type"), processor, ApprovalType.ApprovalTypeBuilder.class, getType_());
			processor.processBasic(path.newSubPath("status"), String.class, getStatus(), this);
			processRosetta(path.newSubPath("approver"), processor, PersonId.PersonIdBuilder.class, getApprover());
			processRosetta(path.newSubPath("approvingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getApprovingPartyReference());
			processRosetta(path.newSubPath("approvedPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getApprovedPartyReference());
			processRosetta(path.newSubPath("approvalId"), processor, ApprovalId.ApprovalIdBuilder.class, getApprovalId());
		}
		

		Approval.ApprovalBuilder prune();
	}

	/*********************** Immutable Implementation of Approval  ***********************/
	class ApprovalImpl implements Approval {
		private final ApprovalType type;
		private final String status;
		private final PersonId approver;
		private final PartyReference approvingPartyReference;
		private final PartyReference approvedPartyReference;
		private final ApprovalId approvalId;
		
		protected ApprovalImpl(Approval.ApprovalBuilder builder) {
			this.type = ofNullable(builder.getType_()).map(f->f.build()).orElse(null);
			this.status = builder.getStatus();
			this.approver = ofNullable(builder.getApprover()).map(f->f.build()).orElse(null);
			this.approvingPartyReference = ofNullable(builder.getApprovingPartyReference()).map(f->f.build()).orElse(null);
			this.approvedPartyReference = ofNullable(builder.getApprovedPartyReference()).map(f->f.build()).orElse(null);
			this.approvalId = ofNullable(builder.getApprovalId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		public ApprovalType getType_() {
			return type;
		}
		
		@Override
		@RosettaAttribute("status")
		public String getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("approver")
		public PersonId getApprover() {
			return approver;
		}
		
		@Override
		@RosettaAttribute("approvingPartyReference")
		public PartyReference getApprovingPartyReference() {
			return approvingPartyReference;
		}
		
		@Override
		@RosettaAttribute("approvedPartyReference")
		public PartyReference getApprovedPartyReference() {
			return approvedPartyReference;
		}
		
		@Override
		@RosettaAttribute("approvalId")
		public ApprovalId getApprovalId() {
			return approvalId;
		}
		
		@Override
		public Approval build() {
			return this;
		}
		
		@Override
		public Approval.ApprovalBuilder toBuilder() {
			Approval.ApprovalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Approval.ApprovalBuilder builder) {
			ofNullable(getType_()).ifPresent(builder::setType);
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getApprover()).ifPresent(builder::setApprover);
			ofNullable(getApprovingPartyReference()).ifPresent(builder::setApprovingPartyReference);
			ofNullable(getApprovedPartyReference()).ifPresent(builder::setApprovedPartyReference);
			ofNullable(getApprovalId()).ifPresent(builder::setApprovalId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Approval _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(approvedPartyReference, _that.getApprovedPartyReference())) return false;
			if (!Objects.equals(approvalId, _that.getApprovalId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (approvedPartyReference != null ? approvedPartyReference.hashCode() : 0);
			_result = 31 * _result + (approvalId != null ? approvalId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Approval {" +
				"type=" + this.type + ", " +
				"status=" + this.status + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"approvedPartyReference=" + this.approvedPartyReference + ", " +
				"approvalId=" + this.approvalId +
			'}';
		}
	}

	/*********************** Builder Implementation of Approval  ***********************/
	class ApprovalBuilderImpl implements Approval.ApprovalBuilder {
	
		protected ApprovalType.ApprovalTypeBuilder type;
		protected String status;
		protected PersonId.PersonIdBuilder approver;
		protected PartyReference.PartyReferenceBuilder approvingPartyReference;
		protected PartyReference.PartyReferenceBuilder approvedPartyReference;
		protected ApprovalId.ApprovalIdBuilder approvalId;
	
		public ApprovalBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("type")
		public ApprovalType.ApprovalTypeBuilder getType_() {
			return type;
		}
		
		@Override
		public ApprovalType.ApprovalTypeBuilder getOrCreateType() {
			ApprovalType.ApprovalTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = ApprovalType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("status")
		public String getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("approver")
		public PersonId.PersonIdBuilder getApprover() {
			return approver;
		}
		
		@Override
		public PersonId.PersonIdBuilder getOrCreateApprover() {
			PersonId.PersonIdBuilder result;
			if (approver!=null) {
				result = approver;
			}
			else {
				result = approver = PersonId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvingPartyReference")
		public PartyReference.PartyReferenceBuilder getApprovingPartyReference() {
			return approvingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateApprovingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (approvingPartyReference!=null) {
				result = approvingPartyReference;
			}
			else {
				result = approvingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvedPartyReference")
		public PartyReference.PartyReferenceBuilder getApprovedPartyReference() {
			return approvedPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateApprovedPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (approvedPartyReference!=null) {
				result = approvedPartyReference;
			}
			else {
				result = approvedPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("approvalId")
		public ApprovalId.ApprovalIdBuilder getApprovalId() {
			return approvalId;
		}
		
		@Override
		public ApprovalId.ApprovalIdBuilder getOrCreateApprovalId() {
			ApprovalId.ApprovalIdBuilder result;
			if (approvalId!=null) {
				result = approvalId;
			}
			else {
				result = approvalId = ApprovalId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("type")
		public Approval.ApprovalBuilder setType(ApprovalType type) {
			this.type = type==null?null:type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("status")
		public Approval.ApprovalBuilder setStatus(String status) {
			this.status = status==null?null:status;
			return this;
		}
		@Override
		@RosettaAttribute("approver")
		public Approval.ApprovalBuilder setApprover(PersonId approver) {
			this.approver = approver==null?null:approver.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approvingPartyReference")
		public Approval.ApprovalBuilder setApprovingPartyReference(PartyReference approvingPartyReference) {
			this.approvingPartyReference = approvingPartyReference==null?null:approvingPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approvedPartyReference")
		public Approval.ApprovalBuilder setApprovedPartyReference(PartyReference approvedPartyReference) {
			this.approvedPartyReference = approvedPartyReference==null?null:approvedPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("approvalId")
		public Approval.ApprovalBuilder setApprovalId(ApprovalId approvalId) {
			this.approvalId = approvalId==null?null:approvalId.toBuilder();
			return this;
		}
		
		@Override
		public Approval build() {
			return new Approval.ApprovalImpl(this);
		}
		
		@Override
		public Approval.ApprovalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Approval.ApprovalBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			if (approver!=null && !approver.prune().hasData()) approver = null;
			if (approvingPartyReference!=null && !approvingPartyReference.prune().hasData()) approvingPartyReference = null;
			if (approvedPartyReference!=null && !approvedPartyReference.prune().hasData()) approvedPartyReference = null;
			if (approvalId!=null && !approvalId.prune().hasData()) approvalId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getType_()!=null && getType_().hasData()) return true;
			if (getStatus()!=null) return true;
			if (getApprover()!=null && getApprover().hasData()) return true;
			if (getApprovingPartyReference()!=null && getApprovingPartyReference().hasData()) return true;
			if (getApprovedPartyReference()!=null && getApprovedPartyReference().hasData()) return true;
			if (getApprovalId()!=null && getApprovalId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Approval.ApprovalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Approval.ApprovalBuilder o = (Approval.ApprovalBuilder) other;
			
			merger.mergeRosetta(getType_(), o.getType_(), this::setType);
			merger.mergeRosetta(getApprover(), o.getApprover(), this::setApprover);
			merger.mergeRosetta(getApprovingPartyReference(), o.getApprovingPartyReference(), this::setApprovingPartyReference);
			merger.mergeRosetta(getApprovedPartyReference(), o.getApprovedPartyReference(), this::setApprovedPartyReference);
			merger.mergeRosetta(getApprovalId(), o.getApprovalId(), this::setApprovalId);
			
			merger.mergeBasic(getStatus(), o.getStatus(), this::setStatus);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Approval _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(approver, _that.getApprover())) return false;
			if (!Objects.equals(approvingPartyReference, _that.getApprovingPartyReference())) return false;
			if (!Objects.equals(approvedPartyReference, _that.getApprovedPartyReference())) return false;
			if (!Objects.equals(approvalId, _that.getApprovalId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (status != null ? status.hashCode() : 0);
			_result = 31 * _result + (approver != null ? approver.hashCode() : 0);
			_result = 31 * _result + (approvingPartyReference != null ? approvingPartyReference.hashCode() : 0);
			_result = 31 * _result + (approvedPartyReference != null ? approvedPartyReference.hashCode() : 0);
			_result = 31 * _result + (approvalId != null ? approvalId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalBuilder {" +
				"type=" + this.type + ", " +
				"status=" + this.status + ", " +
				"approver=" + this.approver + ", " +
				"approvingPartyReference=" + this.approvingPartyReference + ", " +
				"approvedPartyReference=" + this.approvedPartyReference + ", " +
				"approvalId=" + this.approvalId +
			'}';
		}
	}
}
