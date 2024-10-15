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
import fpml.confirmation.DayOfWeekExtEnum;
import fpml.confirmation.GenericCommodityDeliveryPeriod;
import fpml.confirmation.GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder;
import fpml.confirmation.GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilderImpl;
import fpml.confirmation.GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodImpl;
import fpml.confirmation.GenericCommodityDeliveryPeriodSequence;
import fpml.confirmation.meta.GenericCommodityDeliveryPeriodMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="GenericCommodityDeliveryPeriod", builder=GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilderImpl.class, version="${project.version}")
public interface GenericCommodityDeliveryPeriod extends RosettaModelObject {

	GenericCommodityDeliveryPeriodMeta metaData = new GenericCommodityDeliveryPeriodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the Applicable Day with respect to a range of Settlement Periods.
	 */
	List<DayOfWeekExtEnum> getApplicableDay();
	GenericCommodityDeliveryPeriodSequence getGenericCommodityDeliveryPeriodSequence();

	/*********************** Build Methods  ***********************/
	GenericCommodityDeliveryPeriod build();
	
	GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder toBuilder();
	
	static GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder builder() {
		return new GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericCommodityDeliveryPeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericCommodityDeliveryPeriod> getType() {
		return GenericCommodityDeliveryPeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicableDay"), DayOfWeekExtEnum.class, getApplicableDay(), this);
		processRosetta(path.newSubPath("genericCommodityDeliveryPeriodSequence"), processor, GenericCommodityDeliveryPeriodSequence.class, getGenericCommodityDeliveryPeriodSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericCommodityDeliveryPeriodBuilder extends GenericCommodityDeliveryPeriod, RosettaModelObjectBuilder {
		GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder getOrCreateGenericCommodityDeliveryPeriodSequence();
		GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder getGenericCommodityDeliveryPeriodSequence();
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder addApplicableDay(DayOfWeekExtEnum applicableDay0);
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder addApplicableDay(DayOfWeekExtEnum applicableDay1, int _idx);
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder addApplicableDay(List<DayOfWeekExtEnum> applicableDay2);
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder setApplicableDay(List<DayOfWeekExtEnum> applicableDay3);
		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder setGenericCommodityDeliveryPeriodSequence(GenericCommodityDeliveryPeriodSequence genericCommodityDeliveryPeriodSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicableDay"), DayOfWeekExtEnum.class, getApplicableDay(), this);
			processRosetta(path.newSubPath("genericCommodityDeliveryPeriodSequence"), processor, GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder.class, getGenericCommodityDeliveryPeriodSequence());
		}
		

		GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of GenericCommodityDeliveryPeriod  ***********************/
	class GenericCommodityDeliveryPeriodImpl implements GenericCommodityDeliveryPeriod {
		private final List<DayOfWeekExtEnum> applicableDay;
		private final GenericCommodityDeliveryPeriodSequence genericCommodityDeliveryPeriodSequence;
		
		protected GenericCommodityDeliveryPeriodImpl(GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder builder) {
			this.applicableDay = ofNullable(builder.getApplicableDay()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.genericCommodityDeliveryPeriodSequence = ofNullable(builder.getGenericCommodityDeliveryPeriodSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicableDay")
		public List<DayOfWeekExtEnum> getApplicableDay() {
			return applicableDay;
		}
		
		@Override
		@RosettaAttribute("genericCommodityDeliveryPeriodSequence")
		public GenericCommodityDeliveryPeriodSequence getGenericCommodityDeliveryPeriodSequence() {
			return genericCommodityDeliveryPeriodSequence;
		}
		
		@Override
		public GenericCommodityDeliveryPeriod build() {
			return this;
		}
		
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder toBuilder() {
			GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder builder) {
			ofNullable(getApplicableDay()).ifPresent(builder::setApplicableDay);
			ofNullable(getGenericCommodityDeliveryPeriodSequence()).ifPresent(builder::setGenericCommodityDeliveryPeriodSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericCommodityDeliveryPeriod _that = getType().cast(o);
		
			if (!ListEquals.listEquals(applicableDay, _that.getApplicableDay())) return false;
			if (!Objects.equals(genericCommodityDeliveryPeriodSequence, _that.getGenericCommodityDeliveryPeriodSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableDay != null ? applicableDay.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (genericCommodityDeliveryPeriodSequence != null ? genericCommodityDeliveryPeriodSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericCommodityDeliveryPeriod {" +
				"applicableDay=" + this.applicableDay + ", " +
				"genericCommodityDeliveryPeriodSequence=" + this.genericCommodityDeliveryPeriodSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of GenericCommodityDeliveryPeriod  ***********************/
	class GenericCommodityDeliveryPeriodBuilderImpl implements GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder {
	
		protected List<DayOfWeekExtEnum> applicableDay = new ArrayList<>();
		protected GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder genericCommodityDeliveryPeriodSequence;
	
		public GenericCommodityDeliveryPeriodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("applicableDay")
		public List<DayOfWeekExtEnum> getApplicableDay() {
			return applicableDay;
		}
		
		@Override
		@RosettaAttribute("genericCommodityDeliveryPeriodSequence")
		public GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder getGenericCommodityDeliveryPeriodSequence() {
			return genericCommodityDeliveryPeriodSequence;
		}
		
		@Override
		public GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder getOrCreateGenericCommodityDeliveryPeriodSequence() {
			GenericCommodityDeliveryPeriodSequence.GenericCommodityDeliveryPeriodSequenceBuilder result;
			if (genericCommodityDeliveryPeriodSequence!=null) {
				result = genericCommodityDeliveryPeriodSequence;
			}
			else {
				result = genericCommodityDeliveryPeriodSequence = GenericCommodityDeliveryPeriodSequence.builder();
			}
			
			return result;
		}
		
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder addApplicableDay(DayOfWeekExtEnum applicableDay) {
			if (applicableDay!=null) this.applicableDay.add(applicableDay);
			return this;
		}
		
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder addApplicableDay(DayOfWeekExtEnum applicableDay, int _idx) {
			getIndex(this.applicableDay, _idx, () -> applicableDay);
			return this;
		}
		@Override 
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder addApplicableDay(List<DayOfWeekExtEnum> applicableDays) {
			if (applicableDays != null) {
				for (DayOfWeekExtEnum toAdd : applicableDays) {
					this.applicableDay.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("applicableDay")
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder setApplicableDay(List<DayOfWeekExtEnum> applicableDays) {
			if (applicableDays == null)  {
				this.applicableDay = new ArrayList<>();
			}
			else {
				this.applicableDay = applicableDays.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("genericCommodityDeliveryPeriodSequence")
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder setGenericCommodityDeliveryPeriodSequence(GenericCommodityDeliveryPeriodSequence genericCommodityDeliveryPeriodSequence) {
			this.genericCommodityDeliveryPeriodSequence = genericCommodityDeliveryPeriodSequence==null?null:genericCommodityDeliveryPeriodSequence.toBuilder();
			return this;
		}
		
		@Override
		public GenericCommodityDeliveryPeriod build() {
			return new GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodImpl(this);
		}
		
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder prune() {
			if (genericCommodityDeliveryPeriodSequence!=null && !genericCommodityDeliveryPeriodSequence.prune().hasData()) genericCommodityDeliveryPeriodSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicableDay()!=null && !getApplicableDay().isEmpty()) return true;
			if (getGenericCommodityDeliveryPeriodSequence()!=null && getGenericCommodityDeliveryPeriodSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder o = (GenericCommodityDeliveryPeriod.GenericCommodityDeliveryPeriodBuilder) other;
			
			merger.mergeRosetta(getGenericCommodityDeliveryPeriodSequence(), o.getGenericCommodityDeliveryPeriodSequence(), this::setGenericCommodityDeliveryPeriodSequence);
			
			merger.mergeBasic(getApplicableDay(), o.getApplicableDay(), (Consumer<DayOfWeekExtEnum>) this::addApplicableDay);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GenericCommodityDeliveryPeriod _that = getType().cast(o);
		
			if (!ListEquals.listEquals(applicableDay, _that.getApplicableDay())) return false;
			if (!Objects.equals(genericCommodityDeliveryPeriodSequence, _that.getGenericCommodityDeliveryPeriodSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableDay != null ? applicableDay.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (genericCommodityDeliveryPeriodSequence != null ? genericCommodityDeliveryPeriodSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericCommodityDeliveryPeriodBuilder {" +
				"applicableDay=" + this.applicableDay + ", " +
				"genericCommodityDeliveryPeriodSequence=" + this.genericCommodityDeliveryPeriodSequence +
			'}';
		}
	}
}
