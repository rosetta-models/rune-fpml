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
import fpml.confirmation.AbstractLoanPartyProfileNotification;
import fpml.confirmation.AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder;
import fpml.confirmation.AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilderImpl;
import fpml.confirmation.AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationImpl;
import fpml.confirmation.CorrelationAndSequenceModel;
import fpml.confirmation.EventInstructionOverride;
import fpml.confirmation.LoanPartyEventInstructionOverrideNotification;
import fpml.confirmation.LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder;
import fpml.confirmation.LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilderImpl;
import fpml.confirmation.LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationImpl;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.Party;
import fpml.confirmation.RequestMessageHeader;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.meta.LoanPartyEventInstructionOverrideNotificationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A set of instructions communicated by parties to override standard payment details for a specific to a set of (any) loan events.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanPartyEventInstructionOverrideNotification", builder=LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilderImpl.class, version="${project.version}")
public interface LoanPartyEventInstructionOverrideNotification extends AbstractLoanPartyProfileNotification {

	LoanPartyEventInstructionOverrideNotificationMeta metaData = new LoanPartyEventInstructionOverrideNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The event for which the (currency-specific) settlement instructions should be applied.
	 */
	EventInstructionOverride getOverride();
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanPartyEventInstructionOverrideNotification build();
	
	LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder toBuilder();
	
	static LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder builder() {
		return new LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanPartyEventInstructionOverrideNotification> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanPartyEventInstructionOverrideNotification> getType() {
		return LoanPartyEventInstructionOverrideNotification.class;
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
		processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
		processRosetta(path.newSubPath("override"), processor, EventInstructionOverride.class, getOverride());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanPartyEventInstructionOverrideNotificationBuilder extends LoanPartyEventInstructionOverrideNotification, AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilder {
		EventInstructionOverride.EventInstructionOverrideBuilder getOrCreateOverride();
		EventInstructionOverride.EventInstructionOverrideBuilder getOverride();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setExpectedBuild(Integer expectedBuild);
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setActualBuild(Integer actualBuild);
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setHeader(RequestMessageHeader header);
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setValidationModel(ValidationModel validationModel);
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setIsCorrection(Boolean isCorrection);
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel);
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel);
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setComments(String comments);
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setOverride(EventInstructionOverride override);
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder addParty(Party party0);
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder addParty(Party party1, int _idx);
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder addParty(List<? extends Party> party2);
		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setParty(List<? extends Party> party3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validationModel"), processor, ValidationModel.ValidationModelBuilder.class, getValidationModel());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("correlationAndSequenceModel"), processor, CorrelationAndSequenceModel.CorrelationAndSequenceModelBuilder.class, getCorrelationAndSequenceModel());
			processRosetta(path.newSubPath("onBehalfOfModel"), processor, OnBehalfOfModel.OnBehalfOfModelBuilder.class, getOnBehalfOfModel());
			processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
			processRosetta(path.newSubPath("override"), processor, EventInstructionOverride.EventInstructionOverrideBuilder.class, getOverride());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanPartyEventInstructionOverrideNotification  ***********************/
	class LoanPartyEventInstructionOverrideNotificationImpl extends AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationImpl implements LoanPartyEventInstructionOverrideNotification {
		private final EventInstructionOverride override;
		private final List<? extends Party> party;
		
		protected LoanPartyEventInstructionOverrideNotificationImpl(LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder builder) {
			super(builder);
			this.override = ofNullable(builder.getOverride()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("override")
		public EventInstructionOverride getOverride() {
			return override;
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanPartyEventInstructionOverrideNotification build() {
			return this;
		}
		
		@Override
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder toBuilder() {
			LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOverride()).ifPresent(builder::setOverride);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanPartyEventInstructionOverrideNotification _that = getType().cast(o);
		
			if (!Objects.equals(override, _that.getOverride())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (override != null ? override.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanPartyEventInstructionOverrideNotification {" +
				"override=" + this.override + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanPartyEventInstructionOverrideNotification  ***********************/
	class LoanPartyEventInstructionOverrideNotificationBuilderImpl extends AbstractLoanPartyProfileNotification.AbstractLoanPartyProfileNotificationBuilderImpl  implements LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder {
	
		protected EventInstructionOverride.EventInstructionOverrideBuilder override;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
	
		public LoanPartyEventInstructionOverrideNotificationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("override")
		public EventInstructionOverride.EventInstructionOverrideBuilder getOverride() {
			return override;
		}
		
		@Override
		public EventInstructionOverride.EventInstructionOverrideBuilder getOrCreateOverride() {
			EventInstructionOverride.EventInstructionOverrideBuilder result;
			if (override!=null) {
				result = override;
			}
			else {
				result = override = EventInstructionOverride.builder();
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
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setExpectedBuild(Integer expectedBuild) {
			this.expectedBuild = expectedBuild==null?null:expectedBuild;
			return this;
		}
		@Override
		@RosettaAttribute("actualBuild")
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setActualBuild(Integer actualBuild) {
			this.actualBuild = actualBuild==null?null:actualBuild;
			return this;
		}
		@Override
		@RosettaAttribute("header")
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setHeader(RequestMessageHeader header) {
			this.header = header==null?null:header.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("validationModel")
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setValidationModel(ValidationModel validationModel) {
			this.validationModel = validationModel==null?null:validationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isCorrection")
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setIsCorrection(Boolean isCorrection) {
			this.isCorrection = isCorrection==null?null:isCorrection;
			return this;
		}
		@Override
		@RosettaAttribute("correlationAndSequenceModel")
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setCorrelationAndSequenceModel(CorrelationAndSequenceModel correlationAndSequenceModel) {
			this.correlationAndSequenceModel = correlationAndSequenceModel==null?null:correlationAndSequenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("onBehalfOfModel")
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setOnBehalfOfModel(OnBehalfOfModel onBehalfOfModel) {
			this.onBehalfOfModel = onBehalfOfModel==null?null:onBehalfOfModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comments")
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setComments(String comments) {
			this.comments = comments==null?null:comments;
			return this;
		}
		@Override
		@RosettaAttribute("override")
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setOverride(EventInstructionOverride override) {
			this.override = override==null?null:override.toBuilder();
			return this;
		}
		@Override
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("party")
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanPartyEventInstructionOverrideNotification build() {
			return new LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationImpl(this);
		}
		
		@Override
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder prune() {
			super.prune();
			if (override!=null && !override.prune().hasData()) override = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOverride()!=null && getOverride().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder o = (LoanPartyEventInstructionOverrideNotification.LoanPartyEventInstructionOverrideNotificationBuilder) other;
			
			merger.mergeRosetta(getOverride(), o.getOverride(), this::setOverride);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanPartyEventInstructionOverrideNotification _that = getType().cast(o);
		
			if (!Objects.equals(override, _that.getOverride())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (override != null ? override.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanPartyEventInstructionOverrideNotificationBuilder {" +
				"override=" + this.override + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
