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
import fpml.confirmation.CorrectableRequestMessage;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilder;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl;
import fpml.confirmation.CorrectableRequestMessage.CorrectableRequestMessageImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.CreditEventNoticeDocument;
import fpml.confirmation.CreditEventNotification;
import fpml.confirmation.CreditEventNotification.CreditEventNotificationBuilder;
import fpml.confirmation.CreditEventNotification.CreditEventNotificationBuilderImpl;
import fpml.confirmation.CreditEventNotification.CreditEventNotificationImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.CreditEventNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A message defining the ISDA defined Credit Event Notice. ISDA defines it as an irrevocable notice from a Notifying Party to the other party that describes a Credit Event that occurred. A Credit Event Notice must contain detail of the facts relevant to the determination that a Credit Event has occurred. A message type defining the ISDA defined Credit Event Notice. ISDA defines it as an irrevocable notice from a Notifying Party to the other party that describes a Credit Event that occurred. A Credit Event Notice must contain detail of the facts relevant to the determination that a Credit Event has occurred.
 * @version ${project.version}
 */
@RosettaDataType(value="CreditEventNotification", builder=CreditEventNotification.CreditEventNotificationBuilderImpl.class, version="${project.version}")
public interface CreditEventNotification extends CorrectableRequestMessage {

	CreditEventNotificationMeta metaData = new CreditEventNotificationMeta();

	/*********************** Getter Methods  ***********************/
	CreditEventNoticeDocument getCreditEventNotice();
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	CreditEventNotification build();
	
	CreditEventNotification.CreditEventNotificationBuilder toBuilder();
	
	static CreditEventNotification.CreditEventNotificationBuilder builder() {
		return new CreditEventNotification.CreditEventNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditEventNotification> getType() {
		return CreditEventNotification.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("creditEventNotice"), processor, CreditEventNoticeDocument.class, getCreditEventNotice());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventNotificationBuilder extends CreditEventNotification, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder getOrCreateCreditEventNotice();
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder getCreditEventNotice();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		CreditEventNotification.CreditEventNotificationBuilder setExpectedBuild(Integer expectedBuild);
		CreditEventNotification.CreditEventNotificationBuilder setActualBuild(Integer actualBuild);
		CreditEventNotification.CreditEventNotificationBuilder setHeader(RequestMessageHeader header);
		CreditEventNotification.CreditEventNotificationBuilder setValidationModel(ValidationModel validationModel);
		CreditEventNotification.CreditEventNotificationBuilder setIsCorrection(Boolean isCorrection);
		CreditEventNotification.CreditEventNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		CreditEventNotification.CreditEventNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		CreditEventNotification.CreditEventNotificationBuilder setCreditEventNotice(CreditEventNoticeDocument creditEventNotice);
		CreditEventNotification.CreditEventNotificationBuilder addParty(Party party0);
		CreditEventNotification.CreditEventNotificationBuilder addParty(Party party1, int _idx);
		CreditEventNotification.CreditEventNotificationBuilder addParty(List<? extends Party> party2);
		CreditEventNotification.CreditEventNotificationBuilder setParty(List<? extends Party> party3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("creditEventNotice"), processor, CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder.class, getCreditEventNotice());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		CreditEventNotification.CreditEventNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventNotification  ***********************/
	class CreditEventNotificationImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements CreditEventNotification {
		private final CreditEventNoticeDocument creditEventNotice;
		private final List<? extends Party> party;
		
		protected CreditEventNotificationImpl(CreditEventNotification.CreditEventNotificationBuilder builder) {
			super(builder);
			this.creditEventNotice = ofNullable(builder.getCreditEventNotice()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditEventNotice")
		public CreditEventNoticeDocument getCreditEventNotice() {
			return creditEventNotice;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public CreditEventNotification build() {
			return this;
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder toBuilder() {
			CreditEventNotification.CreditEventNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventNotification.CreditEventNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCreditEventNotice()).ifPresent(builder::setCreditEventNotice);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditEventNotification _that = getType().cast(o);
		
			if (!Objects.equals(creditEventNotice, _that.getCreditEventNotice())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (creditEventNotice != null ? creditEventNotice.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventNotification {" +
				"creditEventNotice=" + this.creditEventNotice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditEventNotification  ***********************/
	class CreditEventNotificationBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl  implements CreditEventNotification.CreditEventNotificationBuilder {
	
		protected CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder creditEventNotice;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public CreditEventNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("creditEventNotice")
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder getCreditEventNotice() {
			return creditEventNotice;
		}
		
		@Override
		public CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder getOrCreateCreditEventNotice() {
			CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder result;
			if (creditEventNotice!=null) {
				result = creditEventNotice;
			}
			else {
				result = creditEventNotice = CreditEventNoticeDocument.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		public Party.PartyBuilder getOrCreateParty(int _index) {
		
			if (party==null) {
				this.party = new ArrayList<>();
			}
			Party.PartyBuilder result;
			return getIndex(party, _index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		public CreditEventNotification.CreditEventNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public CreditEventNotification.CreditEventNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public CreditEventNotification.CreditEventNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public CreditEventNotification.CreditEventNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public CreditEventNotification.CreditEventNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public CreditEventNotification.CreditEventNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public CreditEventNotification.CreditEventNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditEventNotice")
		public CreditEventNotification.CreditEventNotificationBuilder setCreditEventNotice(CreditEventNoticeDocument creditEventNotice) {
			this.creditEventNotice = creditEventNotice==null?null:creditEventNotice.toBuilder();
			return this;
		}
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public CreditEventNotification.CreditEventNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public CreditEventNotification.CreditEventNotificationBuilder setParty(List<? extends Party> partys) {
			if (partys == null)  {
				this.party = new ArrayList<>();
			}
			else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CreditEventNotification build() {
			return new CreditEventNotification.CreditEventNotificationImpl(this);
		}
		
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder prune() {
			super.prune();
			if (creditEventNotice!=null && !creditEventNotice.prune().hasData()) creditEventNotice = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCreditEventNotice()!=null && getCreditEventNotice().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNotification.CreditEventNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditEventNotification.CreditEventNotificationBuilder o = (CreditEventNotification.CreditEventNotificationBuilder) other;
			
			merger.mergeRosetta(getCreditEventNotice(), o.getCreditEventNotice(), this::setCreditEventNotice);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditEventNotification _that = getType().cast(o);
		
			if (!Objects.equals(creditEventNotice, _that.getCreditEventNotice())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (creditEventNotice != null ? creditEventNotice.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventNotificationBuilder {" +
				"creditEventNotice=" + this.creditEventNotice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
