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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import fpml.confirmation.AffectedTransactions;
import fpml.confirmation.CreditEvent;
import fpml.confirmation.CreditEventNoticeDocument;
import fpml.confirmation.CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder;
import fpml.confirmation.CreditEventNoticeDocument.CreditEventNoticeDocumentBuilderImpl;
import fpml.confirmation.CreditEventNoticeDocument.CreditEventNoticeDocumentImpl;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Resource;
import fpml.confirmation.meta.CreditEventNoticeDocumentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event type that records the occurrence of a credit event notice.
 * @version ${project.version}
 */
@RosettaDataType(value="CreditEventNoticeDocument", builder=CreditEventNoticeDocument.CreditEventNoticeDocumentBuilderImpl.class, version="${project.version}")
public interface CreditEventNoticeDocument extends RosettaModelObject {

	CreditEventNoticeDocumentMeta metaData = new CreditEventNoticeDocumentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Trades affected by this event.
	 */
	AffectedTransactions getAffectedTransactions();
	LegalEntity getReferenceEntity();
	CreditEvent getCreditEvent();
	/**
	 * A public information source, e.g. a particular newspaper or electronic news service, that may publish relevant information used in the determination of whether or not a credit event has occurred.
	 */
	List<? extends Resource> getPubliclyAvailableInformation();
	PartyReference getNotifyingPartyReference();
	PartyReference getNotifiedPartyReference();
	Date getCreditEventNoticeDate();
	Date getCreditEventDate();

	/*********************** Build Methods  ***********************/
	CreditEventNoticeDocument build();
	
	CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder toBuilder();
	
	static CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder builder() {
		return new CreditEventNoticeDocument.CreditEventNoticeDocumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventNoticeDocument> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditEventNoticeDocument> getType() {
		return CreditEventNoticeDocument.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("affectedTransactions"), processor, AffectedTransactions.class, getAffectedTransactions());
		processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.class, getReferenceEntity());
		processRosetta(path.newSubPath("creditEvent"), processor, CreditEvent.class, getCreditEvent());
		processRosetta(path.newSubPath("publiclyAvailableInformation"), processor, Resource.class, getPubliclyAvailableInformation());
		processRosetta(path.newSubPath("notifyingPartyReference"), processor, PartyReference.class, getNotifyingPartyReference());
		processRosetta(path.newSubPath("notifiedPartyReference"), processor, PartyReference.class, getNotifiedPartyReference());
		processor.processBasic(path.newSubPath("creditEventNoticeDate"), Date.class, getCreditEventNoticeDate(), this);
		processor.processBasic(path.newSubPath("creditEventDate"), Date.class, getCreditEventDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventNoticeDocumentBuilder extends CreditEventNoticeDocument, RosettaModelObjectBuilder {
		AffectedTransactions.AffectedTransactionsBuilder getOrCreateAffectedTransactions();
		AffectedTransactions.AffectedTransactionsBuilder getAffectedTransactions();
		LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity();
		LegalEntity.LegalEntityBuilder getReferenceEntity();
		CreditEvent.CreditEventBuilder getOrCreateCreditEvent();
		CreditEvent.CreditEventBuilder getCreditEvent();
		Resource.ResourceBuilder getOrCreatePubliclyAvailableInformation(int _index);
		List<? extends Resource.ResourceBuilder> getPubliclyAvailableInformation();
		PartyReference.PartyReferenceBuilder getOrCreateNotifyingPartyReference();
		PartyReference.PartyReferenceBuilder getNotifyingPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateNotifiedPartyReference();
		PartyReference.PartyReferenceBuilder getNotifiedPartyReference();
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setAffectedTransactions(AffectedTransactions affectedTransactions);
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setReferenceEntity(LegalEntity referenceEntity);
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setCreditEvent(CreditEvent creditEvent);
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation0);
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation1, int _idx);
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder addPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformation2);
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformation3);
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setNotifyingPartyReference(PartyReference notifyingPartyReference);
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setNotifiedPartyReference(PartyReference notifiedPartyReference);
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setCreditEventNoticeDate(Date creditEventNoticeDate);
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setCreditEventDate(Date creditEventDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("affectedTransactions"), processor, AffectedTransactions.AffectedTransactionsBuilder.class, getAffectedTransactions());
			processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.LegalEntityBuilder.class, getReferenceEntity());
			processRosetta(path.newSubPath("creditEvent"), processor, CreditEvent.CreditEventBuilder.class, getCreditEvent());
			processRosetta(path.newSubPath("publiclyAvailableInformation"), processor, Resource.ResourceBuilder.class, getPubliclyAvailableInformation());
			processRosetta(path.newSubPath("notifyingPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getNotifyingPartyReference());
			processRosetta(path.newSubPath("notifiedPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getNotifiedPartyReference());
			processor.processBasic(path.newSubPath("creditEventNoticeDate"), Date.class, getCreditEventNoticeDate(), this);
			processor.processBasic(path.newSubPath("creditEventDate"), Date.class, getCreditEventDate(), this);
		}
		

		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventNoticeDocument  ***********************/
	class CreditEventNoticeDocumentImpl implements CreditEventNoticeDocument {
		private final AffectedTransactions affectedTransactions;
		private final LegalEntity referenceEntity;
		private final CreditEvent creditEvent;
		private final List<? extends Resource> publiclyAvailableInformation;
		private final PartyReference notifyingPartyReference;
		private final PartyReference notifiedPartyReference;
		private final Date creditEventNoticeDate;
		private final Date creditEventDate;
		
		protected CreditEventNoticeDocumentImpl(CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder builder) {
			this.affectedTransactions = ofNullable(builder.getAffectedTransactions()).map(f->f.build()).orElse(null);
			this.referenceEntity = ofNullable(builder.getReferenceEntity()).map(f->f.build()).orElse(null);
			this.creditEvent = ofNullable(builder.getCreditEvent()).map(f->f.build()).orElse(null);
			this.publiclyAvailableInformation = ofNullable(builder.getPubliclyAvailableInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.notifyingPartyReference = ofNullable(builder.getNotifyingPartyReference()).map(f->f.build()).orElse(null);
			this.notifiedPartyReference = ofNullable(builder.getNotifiedPartyReference()).map(f->f.build()).orElse(null);
			this.creditEventNoticeDate = builder.getCreditEventNoticeDate();
			this.creditEventDate = builder.getCreditEventDate();
		}
		
		@Override
		@RosettaAttribute("affectedTransactions")
		public AffectedTransactions getAffectedTransactions() {
			return affectedTransactions;
		}
		
		@Override
		@RosettaAttribute("referenceEntity")
		public LegalEntity getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		@RosettaAttribute("creditEvent")
		public CreditEvent getCreditEvent() {
			return creditEvent;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		public List<? extends Resource> getPubliclyAvailableInformation() {
			return publiclyAvailableInformation;
		}
		
		@Override
		@RosettaAttribute("notifyingPartyReference")
		public PartyReference getNotifyingPartyReference() {
			return notifyingPartyReference;
		}
		
		@Override
		@RosettaAttribute("notifiedPartyReference")
		public PartyReference getNotifiedPartyReference() {
			return notifiedPartyReference;
		}
		
		@Override
		@RosettaAttribute("creditEventNoticeDate")
		public Date getCreditEventNoticeDate() {
			return creditEventNoticeDate;
		}
		
		@Override
		@RosettaAttribute("creditEventDate")
		public Date getCreditEventDate() {
			return creditEventDate;
		}
		
		@Override
		public CreditEventNoticeDocument build() {
			return this;
		}
		
		@Override
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder toBuilder() {
			CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder builder) {
			ofNullable(getAffectedTransactions()).ifPresent(builder::setAffectedTransactions);
			ofNullable(getReferenceEntity()).ifPresent(builder::setReferenceEntity);
			ofNullable(getCreditEvent()).ifPresent(builder::setCreditEvent);
			ofNullable(getPubliclyAvailableInformation()).ifPresent(builder::setPubliclyAvailableInformation);
			ofNullable(getNotifyingPartyReference()).ifPresent(builder::setNotifyingPartyReference);
			ofNullable(getNotifiedPartyReference()).ifPresent(builder::setNotifiedPartyReference);
			ofNullable(getCreditEventNoticeDate()).ifPresent(builder::setCreditEventNoticeDate);
			ofNullable(getCreditEventDate()).ifPresent(builder::setCreditEventDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEventNoticeDocument _that = getType().cast(o);
		
			if (!Objects.equals(affectedTransactions, _that.getAffectedTransactions())) return false;
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(creditEvent, _that.getCreditEvent())) return false;
			if (!ListEquals.listEquals(publiclyAvailableInformation, _that.getPubliclyAvailableInformation())) return false;
			if (!Objects.equals(notifyingPartyReference, _that.getNotifyingPartyReference())) return false;
			if (!Objects.equals(notifiedPartyReference, _that.getNotifiedPartyReference())) return false;
			if (!Objects.equals(creditEventNoticeDate, _that.getCreditEventNoticeDate())) return false;
			if (!Objects.equals(creditEventDate, _that.getCreditEventDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (affectedTransactions != null ? affectedTransactions.hashCode() : 0);
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (creditEvent != null ? creditEvent.hashCode() : 0);
			_result = 31 * _result + (publiclyAvailableInformation != null ? publiclyAvailableInformation.hashCode() : 0);
			_result = 31 * _result + (notifyingPartyReference != null ? notifyingPartyReference.hashCode() : 0);
			_result = 31 * _result + (notifiedPartyReference != null ? notifiedPartyReference.hashCode() : 0);
			_result = 31 * _result + (creditEventNoticeDate != null ? creditEventNoticeDate.hashCode() : 0);
			_result = 31 * _result + (creditEventDate != null ? creditEventDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventNoticeDocument {" +
				"affectedTransactions=" + this.affectedTransactions + ", " +
				"referenceEntity=" + this.referenceEntity + ", " +
				"creditEvent=" + this.creditEvent + ", " +
				"publiclyAvailableInformation=" + this.publiclyAvailableInformation + ", " +
				"notifyingPartyReference=" + this.notifyingPartyReference + ", " +
				"notifiedPartyReference=" + this.notifiedPartyReference + ", " +
				"creditEventNoticeDate=" + this.creditEventNoticeDate + ", " +
				"creditEventDate=" + this.creditEventDate +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditEventNoticeDocument  ***********************/
	class CreditEventNoticeDocumentBuilderImpl implements CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder {
	
		protected AffectedTransactions.AffectedTransactionsBuilder affectedTransactions;
		protected LegalEntity.LegalEntityBuilder referenceEntity;
		protected CreditEvent.CreditEventBuilder creditEvent;
		protected List<Resource.ResourceBuilder> publiclyAvailableInformation = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder notifyingPartyReference;
		protected PartyReference.PartyReferenceBuilder notifiedPartyReference;
		protected Date creditEventNoticeDate;
		protected Date creditEventDate;
	
		public CreditEventNoticeDocumentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("affectedTransactions")
		public AffectedTransactions.AffectedTransactionsBuilder getAffectedTransactions() {
			return affectedTransactions;
		}
		
		@Override
		public AffectedTransactions.AffectedTransactionsBuilder getOrCreateAffectedTransactions() {
			AffectedTransactions.AffectedTransactionsBuilder result;
			if (affectedTransactions!=null) {
				result = affectedTransactions;
			}
			else {
				result = affectedTransactions = AffectedTransactions.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceEntity")
		public LegalEntity.LegalEntityBuilder getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity() {
			LegalEntity.LegalEntityBuilder result;
			if (referenceEntity!=null) {
				result = referenceEntity;
			}
			else {
				result = referenceEntity = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEvent")
		public CreditEvent.CreditEventBuilder getCreditEvent() {
			return creditEvent;
		}
		
		@Override
		public CreditEvent.CreditEventBuilder getOrCreateCreditEvent() {
			CreditEvent.CreditEventBuilder result;
			if (creditEvent!=null) {
				result = creditEvent;
			}
			else {
				result = creditEvent = CreditEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		public List<? extends Resource.ResourceBuilder> getPubliclyAvailableInformation() {
			return publiclyAvailableInformation;
		}
		
		public Resource.ResourceBuilder getOrCreatePubliclyAvailableInformation(int _index) {
		
			if (publiclyAvailableInformation==null) {
				this.publiclyAvailableInformation = new ArrayList<>();
			}
			Resource.ResourceBuilder result;
			return getIndex(publiclyAvailableInformation, _index, () -> {
						Resource.ResourceBuilder newPubliclyAvailableInformation = Resource.builder();
						return newPubliclyAvailableInformation;
					});
		}
		
		@Override
		@RosettaAttribute("notifyingPartyReference")
		public PartyReference.PartyReferenceBuilder getNotifyingPartyReference() {
			return notifyingPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateNotifyingPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (notifyingPartyReference!=null) {
				result = notifyingPartyReference;
			}
			else {
				result = notifyingPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notifiedPartyReference")
		public PartyReference.PartyReferenceBuilder getNotifiedPartyReference() {
			return notifiedPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateNotifiedPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (notifiedPartyReference!=null) {
				result = notifiedPartyReference;
			}
			else {
				result = notifiedPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEventNoticeDate")
		public Date getCreditEventNoticeDate() {
			return creditEventNoticeDate;
		}
		
		@Override
		@RosettaAttribute("creditEventDate")
		public Date getCreditEventDate() {
			return creditEventDate;
		}
		
		@Override
		@RosettaAttribute("affectedTransactions")
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setAffectedTransactions(AffectedTransactions affectedTransactions) {
			this.affectedTransactions = affectedTransactions==null?null:affectedTransactions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referenceEntity")
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setReferenceEntity(LegalEntity referenceEntity) {
			this.referenceEntity = referenceEntity==null?null:referenceEntity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditEvent")
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setCreditEvent(CreditEvent creditEvent) {
			this.creditEvent = creditEvent==null?null:creditEvent.toBuilder();
			return this;
		}
		@Override
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation) {
			if (publiclyAvailableInformation!=null) this.publiclyAvailableInformation.add(publiclyAvailableInformation.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation, int _idx) {
			getIndex(this.publiclyAvailableInformation, _idx, () -> publiclyAvailableInformation.toBuilder());
			return this;
		}
		@Override 
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder addPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformations) {
			if (publiclyAvailableInformations != null) {
				for (Resource toAdd : publiclyAvailableInformations) {
					this.publiclyAvailableInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("publiclyAvailableInformation")
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformations) {
			if (publiclyAvailableInformations == null)  {
				this.publiclyAvailableInformation = new ArrayList<>();
			}
			else {
				this.publiclyAvailableInformation = publiclyAvailableInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("notifyingPartyReference")
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setNotifyingPartyReference(PartyReference notifyingPartyReference) {
			this.notifyingPartyReference = notifyingPartyReference==null?null:notifyingPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notifiedPartyReference")
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setNotifiedPartyReference(PartyReference notifiedPartyReference) {
			this.notifiedPartyReference = notifiedPartyReference==null?null:notifiedPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditEventNoticeDate")
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setCreditEventNoticeDate(Date creditEventNoticeDate) {
			this.creditEventNoticeDate = creditEventNoticeDate==null?null:creditEventNoticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("creditEventDate")
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder setCreditEventDate(Date creditEventDate) {
			this.creditEventDate = creditEventDate==null?null:creditEventDate;
			return this;
		}
		
		@Override
		public CreditEventNoticeDocument build() {
			return new CreditEventNoticeDocument.CreditEventNoticeDocumentImpl(this);
		}
		
		@Override
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder prune() {
			if (affectedTransactions!=null && !affectedTransactions.prune().hasData()) affectedTransactions = null;
			if (referenceEntity!=null && !referenceEntity.prune().hasData()) referenceEntity = null;
			if (creditEvent!=null && !creditEvent.prune().hasData()) creditEvent = null;
			publiclyAvailableInformation = publiclyAvailableInformation.stream().filter(b->b!=null).<Resource.ResourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (notifyingPartyReference!=null && !notifyingPartyReference.prune().hasData()) notifyingPartyReference = null;
			if (notifiedPartyReference!=null && !notifiedPartyReference.prune().hasData()) notifiedPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAffectedTransactions()!=null && getAffectedTransactions().hasData()) return true;
			if (getReferenceEntity()!=null && getReferenceEntity().hasData()) return true;
			if (getCreditEvent()!=null && getCreditEvent().hasData()) return true;
			if (getPubliclyAvailableInformation()!=null && getPubliclyAvailableInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNotifyingPartyReference()!=null && getNotifyingPartyReference().hasData()) return true;
			if (getNotifiedPartyReference()!=null && getNotifiedPartyReference().hasData()) return true;
			if (getCreditEventNoticeDate()!=null) return true;
			if (getCreditEventDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder o = (CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder) other;
			
			merger.mergeRosetta(getAffectedTransactions(), o.getAffectedTransactions(), this::setAffectedTransactions);
			merger.mergeRosetta(getReferenceEntity(), o.getReferenceEntity(), this::setReferenceEntity);
			merger.mergeRosetta(getCreditEvent(), o.getCreditEvent(), this::setCreditEvent);
			merger.mergeRosetta(getPubliclyAvailableInformation(), o.getPubliclyAvailableInformation(), this::getOrCreatePubliclyAvailableInformation);
			merger.mergeRosetta(getNotifyingPartyReference(), o.getNotifyingPartyReference(), this::setNotifyingPartyReference);
			merger.mergeRosetta(getNotifiedPartyReference(), o.getNotifiedPartyReference(), this::setNotifiedPartyReference);
			
			merger.mergeBasic(getCreditEventNoticeDate(), o.getCreditEventNoticeDate(), this::setCreditEventNoticeDate);
			merger.mergeBasic(getCreditEventDate(), o.getCreditEventDate(), this::setCreditEventDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEventNoticeDocument _that = getType().cast(o);
		
			if (!Objects.equals(affectedTransactions, _that.getAffectedTransactions())) return false;
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(creditEvent, _that.getCreditEvent())) return false;
			if (!ListEquals.listEquals(publiclyAvailableInformation, _that.getPubliclyAvailableInformation())) return false;
			if (!Objects.equals(notifyingPartyReference, _that.getNotifyingPartyReference())) return false;
			if (!Objects.equals(notifiedPartyReference, _that.getNotifiedPartyReference())) return false;
			if (!Objects.equals(creditEventNoticeDate, _that.getCreditEventNoticeDate())) return false;
			if (!Objects.equals(creditEventDate, _that.getCreditEventDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (affectedTransactions != null ? affectedTransactions.hashCode() : 0);
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (creditEvent != null ? creditEvent.hashCode() : 0);
			_result = 31 * _result + (publiclyAvailableInformation != null ? publiclyAvailableInformation.hashCode() : 0);
			_result = 31 * _result + (notifyingPartyReference != null ? notifyingPartyReference.hashCode() : 0);
			_result = 31 * _result + (notifiedPartyReference != null ? notifiedPartyReference.hashCode() : 0);
			_result = 31 * _result + (creditEventNoticeDate != null ? creditEventNoticeDate.hashCode() : 0);
			_result = 31 * _result + (creditEventDate != null ? creditEventDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventNoticeDocumentBuilder {" +
				"affectedTransactions=" + this.affectedTransactions + ", " +
				"referenceEntity=" + this.referenceEntity + ", " +
				"creditEvent=" + this.creditEvent + ", " +
				"publiclyAvailableInformation=" + this.publiclyAvailableInformation + ", " +
				"notifyingPartyReference=" + this.notifyingPartyReference + ", " +
				"notifiedPartyReference=" + this.notifiedPartyReference + ", " +
				"creditEventNoticeDate=" + this.creditEventNoticeDate + ", " +
				"creditEventDate=" + this.creditEventDate +
			'}';
		}
	}
}
