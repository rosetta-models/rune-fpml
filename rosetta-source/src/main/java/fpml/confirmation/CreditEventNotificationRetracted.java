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
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.CreditEventNoticeDocument;
import fpml.confirmation.CreditEventNotificationRetracted;
import fpml.confirmation.CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder;
import fpml.confirmation.CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilderImpl;
import fpml.confirmation.CreditEventNotificationRetracted.CreditEventNotificationRetractedImpl;
import fpml.confirmation.NonCorrectableRequestMessage;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl;
import fpml.confirmation.NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.CreditEventNotificationRetractedMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A message retracting a previous credit event notification. A message type retracting a previous credit event notification.
 * @version ${project.version}
 */
@RosettaDataType(value="CreditEventNotificationRetracted", builder=CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilderImpl.class, version="${project.version}")
public interface CreditEventNotificationRetracted extends NonCorrectableRequestMessage {

	CreditEventNotificationRetractedMeta metaData = new CreditEventNotificationRetractedMeta();

	/*********************** Getter Methods  ***********************/
	CreditEventNoticeDocument getCreditEventNotice();
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	CreditEventNotificationRetracted build();
	
	CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder toBuilder();
	
	static CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder builder() {
		return new CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventNotificationRetracted> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditEventNotificationRetracted> getType() {
		return CreditEventNotificationRetracted.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.class, getValidationModel());
		processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.class, getCorrelationAndSequenceModel());
		processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.class, getOnBehalfOfModel());
		processRosetta(path.newSubPath("creditEventNotice"), processor, CreditEventNoticeDocument.class, getCreditEventNotice());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventNotificationRetractedBuilder extends CreditEventNotificationRetracted, NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilder {
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder getOrCreateCreditEventNotice();
		CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder getCreditEventNotice();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setExpectedBuild(Integer expectedBuild);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setActualBuild(Integer actualBuild);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setHeader(RequestMessageHeader header);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setValidationModel(ValidationModel validationModel);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setCreditEventNotice(CreditEventNoticeDocument creditEventNotice);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addParty(Party party0);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addParty(Party party1, int _idx);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addParty(List<? extends Party> party2);
		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setParty(List<? extends Party> party3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processRosetta(path.newSubPath("creditEventNotice"), processor, CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder.class, getCreditEventNotice());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventNotificationRetracted  ***********************/
	class CreditEventNotificationRetractedImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageImpl implements CreditEventNotificationRetracted {
		private final CreditEventNoticeDocument creditEventNotice;
		private final List<? extends Party> party;
		
		protected CreditEventNotificationRetractedImpl(CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder builder) {
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
		public CreditEventNotificationRetracted build() {
			return this;
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder toBuilder() {
			CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCreditEventNotice()).ifPresent(builder::setCreditEventNotice);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditEventNotificationRetracted _that = getType().cast(o);
		
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
			return "CreditEventNotificationRetracted {" +
				"creditEventNotice=" + this.creditEventNotice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditEventNotificationRetracted  ***********************/
	class CreditEventNotificationRetractedBuilderImpl extends NonCorrectableRequestMessage.NonCorrectableRequestMessageBuilderImpl  implements CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder {
	
		protected CreditEventNoticeDocument.CreditEventNoticeDocumentBuilder creditEventNotice;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public CreditEventNotificationRetractedBuilderImpl() {
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
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("creditEventNotice")
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setCreditEventNotice(CreditEventNoticeDocument creditEventNotice) {
			this.creditEventNotice = creditEventNotice==null?null:creditEventNotice.toBuilder();
			return this;
		}
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder setParty(List<? extends Party> partys) {
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
		public CreditEventNotificationRetracted build() {
			return new CreditEventNotificationRetracted.CreditEventNotificationRetractedImpl(this);
		}
		
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder prune() {
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
		public CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder o = (CreditEventNotificationRetracted.CreditEventNotificationRetractedBuilder) other;
			
			merger.mergeRosetta(getCreditEventNotice(), o.getCreditEventNotice(), this::setCreditEventNotice);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditEventNotificationRetracted _that = getType().cast(o);
		
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
			return "CreditEventNotificationRetractedBuilder {" +
				"creditEventNotice=" + this.creditEventNotice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
