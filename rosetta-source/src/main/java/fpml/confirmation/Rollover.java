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
import fpml.confirmation.AbstractFacilityEvent;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilder;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventBuilderImpl;
import fpml.confirmation.AbstractFacilityEvent.AbstractFacilityEventImpl;
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.FacilityReference;
import fpml.confirmation.LenderAndCashDetailsModel;
import fpml.confirmation.Rollover;
import fpml.confirmation.Rollover.RolloverBuilder;
import fpml.confirmation.Rollover.RolloverBuilderImpl;
import fpml.confirmation.Rollover.RolloverImpl;
import fpml.confirmation.RolloverChoice;
import fpml.confirmation.meta.RolloverMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An event representing the prepayment structure associated within a facility.
 * @version ${project.version}
 */
@RosettaDataType(value="Rollover", builder=Rollover.RolloverBuilderImpl.class, version="${project.version}")
public interface Rollover extends AbstractFacilityEvent {

	RolloverMeta metaData = new RolloverMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A list of all contracts that are maturing during the rollover event.
	 */
	String getMaturingContracts();
	/**
	 * A list of all contracts whose rates are resetting or contracts that are initiating as part of the rollover event.
	 */
	String getCurrentContracts();
	List<? extends RolloverChoice> getRolloverChoice();

	/*********************** Build Methods  ***********************/
	Rollover build();
	
	Rollover.RolloverBuilder toBuilder();
	
	static Rollover.RolloverBuilder builder() {
		return new Rollover.RolloverBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Rollover> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Rollover> getType() {
		return Rollover.class;
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
		processor.processBasic(path.newSubPath("maturingContracts"), String.class, getMaturingContracts(), this);
		processor.processBasic(path.newSubPath("currentContracts"), String.class, getCurrentContracts(), this);
		processRosetta(path.newSubPath("rolloverChoice"), processor, RolloverChoice.class, getRolloverChoice());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RolloverBuilder extends Rollover, AbstractFacilityEvent.AbstractFacilityEventBuilder {
		RolloverChoice.RolloverChoiceBuilder getOrCreateRolloverChoice(int _index);
		List<? extends RolloverChoice.RolloverChoiceBuilder> getRolloverChoice();
		Rollover.RolloverBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		Rollover.RolloverBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		Rollover.RolloverBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		Rollover.RolloverBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		Rollover.RolloverBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier);
		Rollover.RolloverBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		Rollover.RolloverBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel);
		Rollover.RolloverBuilder setComment(String comment);
		Rollover.RolloverBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel);
		Rollover.RolloverBuilder setEffectiveDate(Date effectiveDate);
		Rollover.RolloverBuilder setFacilityReference(FacilityReference facilityReference);
		Rollover.RolloverBuilder setMaturingContracts(String maturingContracts);
		Rollover.RolloverBuilder setCurrentContracts(String currentContracts);
		Rollover.RolloverBuilder addRolloverChoice(RolloverChoice rolloverChoice0);
		Rollover.RolloverBuilder addRolloverChoice(RolloverChoice rolloverChoice1, int _idx);
		Rollover.RolloverBuilder addRolloverChoice(List<? extends RolloverChoice> rolloverChoice2);
		Rollover.RolloverBuilder setRolloverChoice(List<? extends RolloverChoice> rolloverChoice3);

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
			processor.processBasic(path.newSubPath("maturingContracts"), String.class, getMaturingContracts(), this);
			processor.processBasic(path.newSubPath("currentContracts"), String.class, getCurrentContracts(), this);
			processRosetta(path.newSubPath("rolloverChoice"), processor, RolloverChoice.RolloverChoiceBuilder.class, getRolloverChoice());
		}
		

		Rollover.RolloverBuilder prune();
	}

	/*********************** Immutable Implementation of Rollover  ***********************/
	class RolloverImpl extends AbstractFacilityEvent.AbstractFacilityEventImpl implements Rollover {
		private final String maturingContracts;
		private final String currentContracts;
		private final List<? extends RolloverChoice> rolloverChoice;
		
		protected RolloverImpl(Rollover.RolloverBuilder builder) {
			super(builder);
			this.maturingContracts = builder.getMaturingContracts();
			this.currentContracts = builder.getCurrentContracts();
			this.rolloverChoice = ofNullable(builder.getRolloverChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("maturingContracts")
		public String getMaturingContracts() {
			return maturingContracts;
		}
		
		@Override
		@RosettaAttribute("currentContracts")
		public String getCurrentContracts() {
			return currentContracts;
		}
		
		@Override
		@RosettaAttribute("rolloverChoice")
		public List<? extends RolloverChoice> getRolloverChoice() {
			return rolloverChoice;
		}
		
		@Override
		public Rollover build() {
			return this;
		}
		
		@Override
		public Rollover.RolloverBuilder toBuilder() {
			Rollover.RolloverBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Rollover.RolloverBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMaturingContracts()).ifPresent(builder::setMaturingContracts);
			ofNullable(getCurrentContracts()).ifPresent(builder::setCurrentContracts);
			ofNullable(getRolloverChoice()).ifPresent(builder::setRolloverChoice);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Rollover _that = getType().cast(o);
		
			if (!Objects.equals(maturingContracts, _that.getMaturingContracts())) return false;
			if (!Objects.equals(currentContracts, _that.getCurrentContracts())) return false;
			if (!ListEquals.listEquals(rolloverChoice, _that.getRolloverChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (maturingContracts != null ? maturingContracts.hashCode() : 0);
			_result = 31 * _result + (currentContracts != null ? currentContracts.hashCode() : 0);
			_result = 31 * _result + (rolloverChoice != null ? rolloverChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Rollover {" +
				"maturingContracts=" + this.maturingContracts + ", " +
				"currentContracts=" + this.currentContracts + ", " +
				"rolloverChoice=" + this.rolloverChoice +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Rollover  ***********************/
	class RolloverBuilderImpl extends AbstractFacilityEvent.AbstractFacilityEventBuilderImpl  implements Rollover.RolloverBuilder {
	
		protected String maturingContracts;
		protected String currentContracts;
		protected List<RolloverChoice.RolloverChoiceBuilder> rolloverChoice = new ArrayList<>();
	
		public RolloverBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("maturingContracts")
		public String getMaturingContracts() {
			return maturingContracts;
		}
		
		@Override
		@RosettaAttribute("currentContracts")
		public String getCurrentContracts() {
			return currentContracts;
		}
		
		@Override
		@RosettaAttribute("rolloverChoice")
		public List<? extends RolloverChoice.RolloverChoiceBuilder> getRolloverChoice() {
			return rolloverChoice;
		}
		
		public RolloverChoice.RolloverChoiceBuilder getOrCreateRolloverChoice(int _index) {
		
			if (rolloverChoice==null) {
				this.rolloverChoice = new ArrayList<>();
			}
			RolloverChoice.RolloverChoiceBuilder result;
			return getIndex(rolloverChoice, _index, () -> {
						RolloverChoice.RolloverChoiceBuilder newRolloverChoice = RolloverChoice.builder();
						return newRolloverChoice;
					});
		}
		
		@Override
		public Rollover.RolloverBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Rollover.RolloverBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public Rollover.RolloverBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public Rollover.RolloverBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public Rollover.RolloverBuilder setParentEventIdentifier(BusinessEventIdentifier parentEventIdentifier) {
			this.parentEventIdentifier = parentEventIdentifier==null?null:parentEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("correctedEventIdentifier")
		public Rollover.RolloverBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier) {
			this.correctedEventIdentifier = correctedEventIdentifier==null?null:correctedEventIdentifier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lenderAndCashDetailsModel")
		public Rollover.RolloverBuilder setLenderAndCashDetailsModel(LenderAndCashDetailsModel lenderAndCashDetailsModel) {
			this.lenderAndCashDetailsModel = lenderAndCashDetailsModel==null?null:lenderAndCashDetailsModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("comment")
		public Rollover.RolloverBuilder setComment(String comment) {
			this.comment = comment==null?null:comment;
			return this;
		}
		@Override
		@RosettaAttribute("businessEventPartiesModel")
		public Rollover.RolloverBuilder setBusinessEventPartiesModel(BusinessEventPartiesModel businessEventPartiesModel) {
			this.businessEventPartiesModel = businessEventPartiesModel==null?null:businessEventPartiesModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public Rollover.RolloverBuilder setEffectiveDate(Date effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate;
			return this;
		}
		@Override
		@RosettaAttribute("facilityReference")
		public Rollover.RolloverBuilder setFacilityReference(FacilityReference facilityReference) {
			this.facilityReference = facilityReference==null?null:facilityReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("maturingContracts")
		public Rollover.RolloverBuilder setMaturingContracts(String maturingContracts) {
			this.maturingContracts = maturingContracts==null?null:maturingContracts;
			return this;
		}
		@Override
		@RosettaAttribute("currentContracts")
		public Rollover.RolloverBuilder setCurrentContracts(String currentContracts) {
			this.currentContracts = currentContracts==null?null:currentContracts;
			return this;
		}
		@Override
		public Rollover.RolloverBuilder addRolloverChoice(RolloverChoice rolloverChoice) {
			if (rolloverChoice!=null) this.rolloverChoice.add(rolloverChoice.toBuilder());
			return this;
		}
		
		@Override
		public Rollover.RolloverBuilder addRolloverChoice(RolloverChoice rolloverChoice, int _idx) {
			getIndex(this.rolloverChoice, _idx, () -> rolloverChoice.toBuilder());
			return this;
		}
		@Override 
		public Rollover.RolloverBuilder addRolloverChoice(List<? extends RolloverChoice> rolloverChoices) {
			if (rolloverChoices != null) {
				for (RolloverChoice toAdd : rolloverChoices) {
					this.rolloverChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("rolloverChoice")
		public Rollover.RolloverBuilder setRolloverChoice(List<? extends RolloverChoice> rolloverChoices) {
			if (rolloverChoices == null)  {
				this.rolloverChoice = new ArrayList<>();
			}
			else {
				this.rolloverChoice = rolloverChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Rollover build() {
			return new Rollover.RolloverImpl(this);
		}
		
		@Override
		public Rollover.RolloverBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Rollover.RolloverBuilder prune() {
			super.prune();
			rolloverChoice = rolloverChoice.stream().filter(b->b!=null).<RolloverChoice.RolloverChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMaturingContracts()!=null) return true;
			if (getCurrentContracts()!=null) return true;
			if (getRolloverChoice()!=null && getRolloverChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Rollover.RolloverBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Rollover.RolloverBuilder o = (Rollover.RolloverBuilder) other;
			
			merger.mergeRosetta(getRolloverChoice(), o.getRolloverChoice(), this::getOrCreateRolloverChoice);
			
			merger.mergeBasic(getMaturingContracts(), o.getMaturingContracts(), this::setMaturingContracts);
			merger.mergeBasic(getCurrentContracts(), o.getCurrentContracts(), this::setCurrentContracts);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Rollover _that = getType().cast(o);
		
			if (!Objects.equals(maturingContracts, _that.getMaturingContracts())) return false;
			if (!Objects.equals(currentContracts, _that.getCurrentContracts())) return false;
			if (!ListEquals.listEquals(rolloverChoice, _that.getRolloverChoice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (maturingContracts != null ? maturingContracts.hashCode() : 0);
			_result = 31 * _result + (currentContracts != null ? currentContracts.hashCode() : 0);
			_result = 31 * _result + (rolloverChoice != null ? rolloverChoice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RolloverBuilder {" +
				"maturingContracts=" + this.maturingContracts + ", " +
				"currentContracts=" + this.currentContracts + ", " +
				"rolloverChoice=" + this.rolloverChoice +
			'}' + " " + super.toString();
		}
	}
}
