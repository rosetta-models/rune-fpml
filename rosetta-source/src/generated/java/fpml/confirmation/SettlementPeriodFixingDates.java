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
import fpml.confirmation.SettlementPeriodFixingDates;
import fpml.confirmation.SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder;
import fpml.confirmation.SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilderImpl;
import fpml.confirmation.SettlementPeriodFixingDates.SettlementPeriodFixingDatesImpl;
import fpml.confirmation.SettlementPeriodFixingDatesSequence;
import fpml.confirmation.meta.SettlementPeriodFixingDatesMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementPeriodFixingDates", builder=SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilderImpl.class, version="${project.version}")
public interface SettlementPeriodFixingDates extends RosettaModelObject {

	SettlementPeriodFixingDatesMeta metaData = new SettlementPeriodFixingDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Observation date in a fixing period.
	 */
	List<Date> getFixingDate();
	SettlementPeriodFixingDatesSequence getSettlementPeriodFixingDatesSequence();
	/**
	 * Number of fixings between the fixing start and end date.
	 */
	Integer getNumberOfFixings();

	/*********************** Build Methods  ***********************/
	SettlementPeriodFixingDates build();
	
	SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder toBuilder();
	
	static SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder builder() {
		return new SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPeriodFixingDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementPeriodFixingDates> getType() {
		return SettlementPeriodFixingDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
		processRosetta(path.newSubPath("settlementPeriodFixingDatesSequence"), processor, SettlementPeriodFixingDatesSequence.class, getSettlementPeriodFixingDatesSequence());
		processor.processBasic(path.newSubPath("numberOfFixings"), Integer.class, getNumberOfFixings(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPeriodFixingDatesBuilder extends SettlementPeriodFixingDates, RosettaModelObjectBuilder {
		SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder getOrCreateSettlementPeriodFixingDatesSequence();
		SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder getSettlementPeriodFixingDatesSequence();
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder addFixingDate(Date fixingDate0);
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder addFixingDate(Date fixingDate1, int _idx);
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder addFixingDate(List<Date> fixingDate2);
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setFixingDate(List<Date> fixingDate3);
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setSettlementPeriodFixingDatesSequence(SettlementPeriodFixingDatesSequence settlementPeriodFixingDatesSequence);
		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setNumberOfFixings(Integer numberOfFixings);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
			processRosetta(path.newSubPath("settlementPeriodFixingDatesSequence"), processor, SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder.class, getSettlementPeriodFixingDatesSequence());
			processor.processBasic(path.newSubPath("numberOfFixings"), Integer.class, getNumberOfFixings(), this);
		}
		

		SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPeriodFixingDates  ***********************/
	class SettlementPeriodFixingDatesImpl implements SettlementPeriodFixingDates {
		private final List<Date> fixingDate;
		private final SettlementPeriodFixingDatesSequence settlementPeriodFixingDatesSequence;
		private final Integer numberOfFixings;
		
		protected SettlementPeriodFixingDatesImpl(SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder builder) {
			this.fixingDate = ofNullable(builder.getFixingDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.settlementPeriodFixingDatesSequence = ofNullable(builder.getSettlementPeriodFixingDatesSequence()).map(f->f.build()).orElse(null);
			this.numberOfFixings = builder.getNumberOfFixings();
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public List<Date> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodFixingDatesSequence")
		public SettlementPeriodFixingDatesSequence getSettlementPeriodFixingDatesSequence() {
			return settlementPeriodFixingDatesSequence;
		}
		
		@Override
		@RosettaAttribute("numberOfFixings")
		public Integer getNumberOfFixings() {
			return numberOfFixings;
		}
		
		@Override
		public SettlementPeriodFixingDates build() {
			return this;
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder toBuilder() {
			SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder builder) {
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
			ofNullable(getSettlementPeriodFixingDatesSequence()).ifPresent(builder::setSettlementPeriodFixingDatesSequence);
			ofNullable(getNumberOfFixings()).ifPresent(builder::setNumberOfFixings);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodFixingDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(settlementPeriodFixingDatesSequence, _that.getSettlementPeriodFixingDatesSequence())) return false;
			if (!Objects.equals(numberOfFixings, _that.getNumberOfFixings())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodFixingDatesSequence != null ? settlementPeriodFixingDatesSequence.hashCode() : 0);
			_result = 31 * _result + (numberOfFixings != null ? numberOfFixings.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodFixingDates {" +
				"fixingDate=" + this.fixingDate + ", " +
				"settlementPeriodFixingDatesSequence=" + this.settlementPeriodFixingDatesSequence + ", " +
				"numberOfFixings=" + this.numberOfFixings +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPeriodFixingDates  ***********************/
	class SettlementPeriodFixingDatesBuilderImpl implements SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder {
	
		protected List<Date> fixingDate = new ArrayList<>();
		protected SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder settlementPeriodFixingDatesSequence;
		protected Integer numberOfFixings;
	
		public SettlementPeriodFixingDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fixingDate")
		public List<Date> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodFixingDatesSequence")
		public SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder getSettlementPeriodFixingDatesSequence() {
			return settlementPeriodFixingDatesSequence;
		}
		
		@Override
		public SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder getOrCreateSettlementPeriodFixingDatesSequence() {
			SettlementPeriodFixingDatesSequence.SettlementPeriodFixingDatesSequenceBuilder result;
			if (settlementPeriodFixingDatesSequence!=null) {
				result = settlementPeriodFixingDatesSequence;
			}
			else {
				result = settlementPeriodFixingDatesSequence = SettlementPeriodFixingDatesSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfFixings")
		public Integer getNumberOfFixings() {
			return numberOfFixings;
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder addFixingDate(Date fixingDate) {
			if (fixingDate!=null) this.fixingDate.add(fixingDate);
			return this;
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder addFixingDate(Date fixingDate, int _idx) {
			getIndex(this.fixingDate, _idx, () -> fixingDate);
			return this;
		}
		@Override 
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder addFixingDate(List<Date> fixingDates) {
			if (fixingDates != null) {
				for (Date toAdd : fixingDates) {
					this.fixingDate.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("fixingDate")
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setFixingDate(List<Date> fixingDates) {
			if (fixingDates == null)  {
				this.fixingDate = new ArrayList<>();
			}
			else {
				this.fixingDate = fixingDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodFixingDatesSequence")
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setSettlementPeriodFixingDatesSequence(SettlementPeriodFixingDatesSequence settlementPeriodFixingDatesSequence) {
			this.settlementPeriodFixingDatesSequence = settlementPeriodFixingDatesSequence==null?null:settlementPeriodFixingDatesSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("numberOfFixings")
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder setNumberOfFixings(Integer numberOfFixings) {
			this.numberOfFixings = numberOfFixings==null?null:numberOfFixings;
			return this;
		}
		
		@Override
		public SettlementPeriodFixingDates build() {
			return new SettlementPeriodFixingDates.SettlementPeriodFixingDatesImpl(this);
		}
		
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder prune() {
			if (settlementPeriodFixingDatesSequence!=null && !settlementPeriodFixingDatesSequence.prune().hasData()) settlementPeriodFixingDatesSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFixingDate()!=null && !getFixingDate().isEmpty()) return true;
			if (getSettlementPeriodFixingDatesSequence()!=null && getSettlementPeriodFixingDatesSequence().hasData()) return true;
			if (getNumberOfFixings()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder o = (SettlementPeriodFixingDates.SettlementPeriodFixingDatesBuilder) other;
			
			merger.mergeRosetta(getSettlementPeriodFixingDatesSequence(), o.getSettlementPeriodFixingDatesSequence(), this::setSettlementPeriodFixingDatesSequence);
			
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), (Consumer<Date>) this::addFixingDate);
			merger.mergeBasic(getNumberOfFixings(), o.getNumberOfFixings(), this::setNumberOfFixings);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPeriodFixingDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			if (!Objects.equals(settlementPeriodFixingDatesSequence, _that.getSettlementPeriodFixingDatesSequence())) return false;
			if (!Objects.equals(numberOfFixings, _that.getNumberOfFixings())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodFixingDatesSequence != null ? settlementPeriodFixingDatesSequence.hashCode() : 0);
			_result = 31 * _result + (numberOfFixings != null ? numberOfFixings.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPeriodFixingDatesBuilder {" +
				"fixingDate=" + this.fixingDate + ", " +
				"settlementPeriodFixingDatesSequence=" + this.settlementPeriodFixingDatesSequence + ", " +
				"numberOfFixings=" + this.numberOfFixings +
			'}';
		}
	}
}
