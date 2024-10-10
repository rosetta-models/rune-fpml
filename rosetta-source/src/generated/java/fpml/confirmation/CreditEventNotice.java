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
import fpml.confirmation.AffectedTransactions;
import fpml.confirmation.CreditEvent;
import fpml.confirmation.CreditEventNotice;
import fpml.confirmation.CreditEventNotice.CreditEventNoticeBuilder;
import fpml.confirmation.CreditEventNotice.CreditEventNoticeBuilderImpl;
import fpml.confirmation.CreditEventNotice.CreditEventNoticeImpl;
import fpml.confirmation.CreditEventNoticeDocument;
import fpml.confirmation.CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder;
import fpml.confirmation.CreditEventNoticeDocument.CreditEventNoticeDocumentBuilderImpl;
import fpml.confirmation.CreditEventNoticeDocument.CreditEventNoticeDocumentImpl;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.PartyReference;
import fpml.confirmation.Resource;
import fpml.confirmation.meta.CreditEventNoticeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * A global element used to hold CENs.
 * @version ${project.version}
 */
@RosettaDataType(value="CreditEventNotice", builder=CreditEventNotice.CreditEventNoticeBuilderImpl.class, version="${project.version}")
public interface CreditEventNotice extends CreditEventNoticeDocument {

	CreditEventNoticeMeta metaData = new CreditEventNoticeMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CreditEventNotice build();
	
	CreditEventNotice.CreditEventNoticeBuilder toBuilder();
	
	static CreditEventNotice.CreditEventNoticeBuilder builder() {
		return new CreditEventNotice.CreditEventNoticeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventNotice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditEventNotice> getType() {
		return CreditEventNotice.class;
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
	interface CreditEventNoticeBuilder extends CreditEventNotice, CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder {
		CreditEventNotice.CreditEventNoticeBuilder setAffectedTransactions(AffectedTransactions affectedTransactions);
		CreditEventNotice.CreditEventNoticeBuilder setReferenceEntity(LegalEntity referenceEntity);
		CreditEventNotice.CreditEventNoticeBuilder setCreditEvent(CreditEvent creditEvent);
		CreditEventNotice.CreditEventNoticeBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation0);
		CreditEventNotice.CreditEventNoticeBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation1, int _idx);
		CreditEventNotice.CreditEventNoticeBuilder addPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformation2);
		CreditEventNotice.CreditEventNoticeBuilder setPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformation3);
		CreditEventNotice.CreditEventNoticeBuilder setNotifyingPartyReference(PartyReference notifyingPartyReference);
		CreditEventNotice.CreditEventNoticeBuilder setNotifiedPartyReference(PartyReference notifiedPartyReference);
		CreditEventNotice.CreditEventNoticeBuilder setCreditEventNoticeDate(Date creditEventNoticeDate);
		CreditEventNotice.CreditEventNoticeBuilder setCreditEventDate(Date creditEventDate);

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
		

		CreditEventNotice.CreditEventNoticeBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventNotice  ***********************/
	class CreditEventNoticeImpl extends CreditEventNoticeDocument.CreditEventNoticeDocumentImpl implements CreditEventNotice {
		
		protected CreditEventNoticeImpl(CreditEventNotice.CreditEventNoticeBuilder builder) {
			super(builder);
		}
		
		@Override
		public CreditEventNotice build() {
			return this;
		}
		
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder toBuilder() {
			CreditEventNotice.CreditEventNoticeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventNotice.CreditEventNoticeBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventNotice {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditEventNotice  ***********************/
	class CreditEventNoticeBuilderImpl extends CreditEventNoticeDocument.CreditEventNoticeDocumentBuilderImpl  implements CreditEventNotice.CreditEventNoticeBuilder {
	
	
		public CreditEventNoticeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("affectedTransactions")
		public CreditEventNotice.CreditEventNoticeBuilder setAffectedTransactions(AffectedTransactions affectedTransactions) {
			this.affectedTransactions = affectedTransactions==null?null:affectedTransactions.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("referenceEntity")
		public CreditEventNotice.CreditEventNoticeBuilder setReferenceEntity(LegalEntity referenceEntity) {
			this.referenceEntity = referenceEntity==null?null:referenceEntity.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditEvent")
		public CreditEventNotice.CreditEventNoticeBuilder setCreditEvent(CreditEvent creditEvent) {
			this.creditEvent = creditEvent==null?null:creditEvent.toBuilder();
			return this;
		}
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation) {
			if (publiclyAvailableInformation!=null) this.publiclyAvailableInformation.add(publiclyAvailableInformation.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation, int _idx) {
			getIndex(this.publiclyAvailableInformation, _idx, () -> publiclyAvailableInformation.toBuilder());
			return this;
		}
		@Override 
		public CreditEventNotice.CreditEventNoticeBuilder addPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformations) {
			if (publiclyAvailableInformations != null) {
				for (Resource toAdd : publiclyAvailableInformations) {
					this.publiclyAvailableInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("publiclyAvailableInformation")
		public CreditEventNotice.CreditEventNoticeBuilder setPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformations) {
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
		public CreditEventNotice.CreditEventNoticeBuilder setNotifyingPartyReference(PartyReference notifyingPartyReference) {
			this.notifyingPartyReference = notifyingPartyReference==null?null:notifyingPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notifiedPartyReference")
		public CreditEventNotice.CreditEventNoticeBuilder setNotifiedPartyReference(PartyReference notifiedPartyReference) {
			this.notifiedPartyReference = notifiedPartyReference==null?null:notifiedPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditEventNoticeDate")
		public CreditEventNotice.CreditEventNoticeBuilder setCreditEventNoticeDate(Date creditEventNoticeDate) {
			this.creditEventNoticeDate = creditEventNoticeDate==null?null:creditEventNoticeDate;
			return this;
		}
		@Override
		@RosettaAttribute("creditEventDate")
		public CreditEventNotice.CreditEventNoticeBuilder setCreditEventDate(Date creditEventDate) {
			this.creditEventDate = creditEventDate==null?null:creditEventDate;
			return this;
		}
		
		@Override
		public CreditEventNotice build() {
			return new CreditEventNotice.CreditEventNoticeImpl(this);
		}
		
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditEventNotice.CreditEventNoticeBuilder o = (CreditEventNotice.CreditEventNoticeBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventNoticeBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
