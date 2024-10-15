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
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.CreditEventNoticeType;
import fpml.confirmation.CreditEventNoticeType.CreditEventNoticeTypeBuilder;
import fpml.confirmation.CreditEventNoticeType.CreditEventNoticeTypeBuilderImpl;
import fpml.confirmation.CreditEventNoticeType.CreditEventNoticeTypeImpl;
import fpml.confirmation.NotifyingParty;
import fpml.confirmation.PubliclyAvailableInformation;
import fpml.confirmation.meta.CreditEventNoticeTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CreditEventNoticeType", builder=CreditEventNoticeType.CreditEventNoticeTypeBuilderImpl.class, version="${project.version}")
public interface CreditEventNoticeType extends RosettaModelObject {

	CreditEventNoticeTypeMeta metaData = new CreditEventNoticeTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Pointer style references to a party identifier defined elsewhere in the document. The notifying party is the party that notifies the other party when a credit event has occurred by means of a credit event notice. If more than one party is referenced as being the notifying party then either party may notify the other of a credit event occurring. ISDA 2003 Term: Notifying Party.
	 */
	NotifyingParty getNotifyingParty();
	/**
	 * Inclusion of this business center element implies that Greenwich Mean Time in Section 3.3 of the 2003 ISDA Credit Derivatives Definitions is replaced by the local time of the city indicated by the businessCenter element value.
	 */
	BusinessCenter getBusinessCenter();
	/**
	 * A specified condition to settlement. Publicly available information means information that reasonably confirms any of the facts relevant to determining that a credit event or potential repudiation/moratorium, as applicable, has occurred. The ISDA defined list (2003) is the market standard and is considered comprehensive, and a minimum of two differing public sources must have published the relevant information, to declare a Credit Event. ISDA 2003 Term: Notice of Publicly Available Information Applicable.
	 */
	PubliclyAvailableInformation getPubliclyAvailableInformation();

	/*********************** Build Methods  ***********************/
	CreditEventNoticeType build();
	
	CreditEventNoticeType.CreditEventNoticeTypeBuilder toBuilder();
	
	static CreditEventNoticeType.CreditEventNoticeTypeBuilder builder() {
		return new CreditEventNoticeType.CreditEventNoticeTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventNoticeType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditEventNoticeType> getType() {
		return CreditEventNoticeType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notifyingParty"), processor, NotifyingParty.class, getNotifyingParty());
		processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.class, getBusinessCenter());
		processRosetta(path.newSubPath("publiclyAvailableInformation"), processor, PubliclyAvailableInformation.class, getPubliclyAvailableInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventNoticeTypeBuilder extends CreditEventNoticeType, RosettaModelObjectBuilder {
		NotifyingParty.NotifyingPartyBuilder getOrCreateNotifyingParty();
		NotifyingParty.NotifyingPartyBuilder getNotifyingParty();
		BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter();
		BusinessCenter.BusinessCenterBuilder getBusinessCenter();
		PubliclyAvailableInformation.PubliclyAvailableInformationBuilder getOrCreatePubliclyAvailableInformation();
		PubliclyAvailableInformation.PubliclyAvailableInformationBuilder getPubliclyAvailableInformation();
		CreditEventNoticeType.CreditEventNoticeTypeBuilder setNotifyingParty(NotifyingParty notifyingParty);
		CreditEventNoticeType.CreditEventNoticeTypeBuilder setBusinessCenter(BusinessCenter businessCenter);
		CreditEventNoticeType.CreditEventNoticeTypeBuilder setPubliclyAvailableInformation(PubliclyAvailableInformation publiclyAvailableInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notifyingParty"), processor, NotifyingParty.NotifyingPartyBuilder.class, getNotifyingParty());
			processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.BusinessCenterBuilder.class, getBusinessCenter());
			processRosetta(path.newSubPath("publiclyAvailableInformation"), processor, PubliclyAvailableInformation.PubliclyAvailableInformationBuilder.class, getPubliclyAvailableInformation());
		}
		

		CreditEventNoticeType.CreditEventNoticeTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventNoticeType  ***********************/
	class CreditEventNoticeTypeImpl implements CreditEventNoticeType {
		private final NotifyingParty notifyingParty;
		private final BusinessCenter businessCenter;
		private final PubliclyAvailableInformation publiclyAvailableInformation;
		
		protected CreditEventNoticeTypeImpl(CreditEventNoticeType.CreditEventNoticeTypeBuilder builder) {
			this.notifyingParty = ofNullable(builder.getNotifyingParty()).map(f->f.build()).orElse(null);
			this.businessCenter = ofNullable(builder.getBusinessCenter()).map(f->f.build()).orElse(null);
			this.publiclyAvailableInformation = ofNullable(builder.getPubliclyAvailableInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notifyingParty")
		public NotifyingParty getNotifyingParty() {
			return notifyingParty;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		public BusinessCenter getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		public PubliclyAvailableInformation getPubliclyAvailableInformation() {
			return publiclyAvailableInformation;
		}
		
		@Override
		public CreditEventNoticeType build() {
			return this;
		}
		
		@Override
		public CreditEventNoticeType.CreditEventNoticeTypeBuilder toBuilder() {
			CreditEventNoticeType.CreditEventNoticeTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventNoticeType.CreditEventNoticeTypeBuilder builder) {
			ofNullable(getNotifyingParty()).ifPresent(builder::setNotifyingParty);
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
			ofNullable(getPubliclyAvailableInformation()).ifPresent(builder::setPubliclyAvailableInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEventNoticeType _that = getType().cast(o);
		
			if (!Objects.equals(notifyingParty, _that.getNotifyingParty())) return false;
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(publiclyAvailableInformation, _that.getPubliclyAvailableInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notifyingParty != null ? notifyingParty.hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			_result = 31 * _result + (publiclyAvailableInformation != null ? publiclyAvailableInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventNoticeType {" +
				"notifyingParty=" + this.notifyingParty + ", " +
				"businessCenter=" + this.businessCenter + ", " +
				"publiclyAvailableInformation=" + this.publiclyAvailableInformation +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditEventNoticeType  ***********************/
	class CreditEventNoticeTypeBuilderImpl implements CreditEventNoticeType.CreditEventNoticeTypeBuilder {
	
		protected NotifyingParty.NotifyingPartyBuilder notifyingParty;
		protected BusinessCenter.BusinessCenterBuilder businessCenter;
		protected PubliclyAvailableInformation.PubliclyAvailableInformationBuilder publiclyAvailableInformation;
	
		public CreditEventNoticeTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notifyingParty")
		public NotifyingParty.NotifyingPartyBuilder getNotifyingParty() {
			return notifyingParty;
		}
		
		@Override
		public NotifyingParty.NotifyingPartyBuilder getOrCreateNotifyingParty() {
			NotifyingParty.NotifyingPartyBuilder result;
			if (notifyingParty!=null) {
				result = notifyingParty;
			}
			else {
				result = notifyingParty = NotifyingParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		public BusinessCenter.BusinessCenterBuilder getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter() {
			BusinessCenter.BusinessCenterBuilder result;
			if (businessCenter!=null) {
				result = businessCenter;
			}
			else {
				result = businessCenter = BusinessCenter.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder getPubliclyAvailableInformation() {
			return publiclyAvailableInformation;
		}
		
		@Override
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder getOrCreatePubliclyAvailableInformation() {
			PubliclyAvailableInformation.PubliclyAvailableInformationBuilder result;
			if (publiclyAvailableInformation!=null) {
				result = publiclyAvailableInformation;
			}
			else {
				result = publiclyAvailableInformation = PubliclyAvailableInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notifyingParty")
		public CreditEventNoticeType.CreditEventNoticeTypeBuilder setNotifyingParty(NotifyingParty notifyingParty) {
			this.notifyingParty = notifyingParty==null?null:notifyingParty.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessCenter")
		public CreditEventNoticeType.CreditEventNoticeTypeBuilder setBusinessCenter(BusinessCenter businessCenter) {
			this.businessCenter = businessCenter==null?null:businessCenter.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		public CreditEventNoticeType.CreditEventNoticeTypeBuilder setPubliclyAvailableInformation(PubliclyAvailableInformation publiclyAvailableInformation) {
			this.publiclyAvailableInformation = publiclyAvailableInformation==null?null:publiclyAvailableInformation.toBuilder();
			return this;
		}
		
		@Override
		public CreditEventNoticeType build() {
			return new CreditEventNoticeType.CreditEventNoticeTypeImpl(this);
		}
		
		@Override
		public CreditEventNoticeType.CreditEventNoticeTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNoticeType.CreditEventNoticeTypeBuilder prune() {
			if (notifyingParty!=null && !notifyingParty.prune().hasData()) notifyingParty = null;
			if (businessCenter!=null && !businessCenter.prune().hasData()) businessCenter = null;
			if (publiclyAvailableInformation!=null && !publiclyAvailableInformation.prune().hasData()) publiclyAvailableInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotifyingParty()!=null && getNotifyingParty().hasData()) return true;
			if (getBusinessCenter()!=null && getBusinessCenter().hasData()) return true;
			if (getPubliclyAvailableInformation()!=null && getPubliclyAvailableInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNoticeType.CreditEventNoticeTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditEventNoticeType.CreditEventNoticeTypeBuilder o = (CreditEventNoticeType.CreditEventNoticeTypeBuilder) other;
			
			merger.mergeRosetta(getNotifyingParty(), o.getNotifyingParty(), this::setNotifyingParty);
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::setBusinessCenter);
			merger.mergeRosetta(getPubliclyAvailableInformation(), o.getPubliclyAvailableInformation(), this::setPubliclyAvailableInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEventNoticeType _that = getType().cast(o);
		
			if (!Objects.equals(notifyingParty, _that.getNotifyingParty())) return false;
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(publiclyAvailableInformation, _that.getPubliclyAvailableInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notifyingParty != null ? notifyingParty.hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			_result = 31 * _result + (publiclyAvailableInformation != null ? publiclyAvailableInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventNoticeTypeBuilder {" +
				"notifyingParty=" + this.notifyingParty + ", " +
				"businessCenter=" + this.businessCenter + ", " +
				"publiclyAvailableInformation=" + this.publiclyAvailableInformation +
			'}';
		}
	}
}
