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
import fpml.confirmation.CalculationPeriodDatesReference;
import fpml.confirmation.DateRelativeToCalculationPeriodDates;
import fpml.confirmation.DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder;
import fpml.confirmation.DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilderImpl;
import fpml.confirmation.DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesImpl;
import fpml.confirmation.meta.DateRelativeToCalculationPeriodDatesMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type to provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
 * @version ${project.version}
 */
@RosettaDataType(value="DateRelativeToCalculationPeriodDates", builder=DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilderImpl.class, version="${project.version}")
public interface DateRelativeToCalculationPeriodDates extends RosettaModelObject {

	DateRelativeToCalculationPeriodDatesMeta metaData = new DateRelativeToCalculationPeriodDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A set of href pointers to calculation period dates defined somewhere else in the document.
	 */
	List<? extends CalculationPeriodDatesReference> getCalculationPeriodDatesReference();

	/*********************** Build Methods  ***********************/
	DateRelativeToCalculationPeriodDates build();
	
	DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder toBuilder();
	
	static DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder builder() {
		return new DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DateRelativeToCalculationPeriodDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DateRelativeToCalculationPeriodDates> getType() {
		return DateRelativeToCalculationPeriodDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, CalculationPeriodDatesReference.class, getCalculationPeriodDatesReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DateRelativeToCalculationPeriodDatesBuilder extends DateRelativeToCalculationPeriodDates, RosettaModelObjectBuilder {
		CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference(int _index);
		List<? extends CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder> getCalculationPeriodDatesReference();
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(CalculationPeriodDatesReference calculationPeriodDatesReference0);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(CalculationPeriodDatesReference calculationPeriodDatesReference1, int _idx);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(List<? extends CalculationPeriodDatesReference> calculationPeriodDatesReference2);
		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder setCalculationPeriodDatesReference(List<? extends CalculationPeriodDatesReference> calculationPeriodDatesReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationPeriodDatesReference"), processor, CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder.class, getCalculationPeriodDatesReference());
		}
		

		DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder prune();
	}

	/*********************** Immutable Implementation of DateRelativeToCalculationPeriodDates  ***********************/
	class DateRelativeToCalculationPeriodDatesImpl implements DateRelativeToCalculationPeriodDates {
		private final List<? extends CalculationPeriodDatesReference> calculationPeriodDatesReference;
		
		protected DateRelativeToCalculationPeriodDatesImpl(DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder builder) {
			this.calculationPeriodDatesReference = ofNullable(builder.getCalculationPeriodDatesReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		public List<? extends CalculationPeriodDatesReference> getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates build() {
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder toBuilder() {
			DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder builder) {
			ofNullable(getCalculationPeriodDatesReference()).ifPresent(builder::setCalculationPeriodDatesReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRelativeToCalculationPeriodDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRelativeToCalculationPeriodDates {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference +
			'}';
		}
	}

	/*********************** Builder Implementation of DateRelativeToCalculationPeriodDates  ***********************/
	class DateRelativeToCalculationPeriodDatesBuilderImpl implements DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder {
	
		protected List<CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder> calculationPeriodDatesReference = new ArrayList<>();
	
		public DateRelativeToCalculationPeriodDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		public List<? extends CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder> getCalculationPeriodDatesReference() {
			return calculationPeriodDatesReference;
		}
		
		@Override
		public CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder getOrCreateCalculationPeriodDatesReference(int _index) {
		
			if (calculationPeriodDatesReference==null) {
				this.calculationPeriodDatesReference = new ArrayList<>();
			}
			CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder result;
			return getIndex(calculationPeriodDatesReference, _index, () -> {
						CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder newCalculationPeriodDatesReference = CalculationPeriodDatesReference.builder();
						return newCalculationPeriodDatesReference;
					});
		}
		
		@Override
		@RosettaAttribute("calculationPeriodDatesReference")
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(CalculationPeriodDatesReference calculationPeriodDatesReference) {
			if (calculationPeriodDatesReference!=null) this.calculationPeriodDatesReference.add(calculationPeriodDatesReference.toBuilder());
			return this;
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(CalculationPeriodDatesReference calculationPeriodDatesReference, int _idx) {
			getIndex(this.calculationPeriodDatesReference, _idx, () -> calculationPeriodDatesReference.toBuilder());
			return this;
		}
		@Override 
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder addCalculationPeriodDatesReference(List<? extends CalculationPeriodDatesReference> calculationPeriodDatesReferences) {
			if (calculationPeriodDatesReferences != null) {
				for (CalculationPeriodDatesReference toAdd : calculationPeriodDatesReferences) {
					this.calculationPeriodDatesReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder setCalculationPeriodDatesReference(List<? extends CalculationPeriodDatesReference> calculationPeriodDatesReferences) {
			if (calculationPeriodDatesReferences == null)  {
				this.calculationPeriodDatesReference = new ArrayList<>();
			}
			else {
				this.calculationPeriodDatesReference = calculationPeriodDatesReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public DateRelativeToCalculationPeriodDates build() {
			return new DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesImpl(this);
		}
		
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder prune() {
			calculationPeriodDatesReference = calculationPeriodDatesReference.stream().filter(b->b!=null).<CalculationPeriodDatesReference.CalculationPeriodDatesReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationPeriodDatesReference()!=null && getCalculationPeriodDatesReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder o = (DateRelativeToCalculationPeriodDates.DateRelativeToCalculationPeriodDatesBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriodDatesReference(), o.getCalculationPeriodDatesReference(), this::getOrCreateCalculationPeriodDatesReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateRelativeToCalculationPeriodDates _that = getType().cast(o);
		
			if (!ListEquals.listEquals(calculationPeriodDatesReference, _that.getCalculationPeriodDatesReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationPeriodDatesReference != null ? calculationPeriodDatesReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateRelativeToCalculationPeriodDatesBuilder {" +
				"calculationPeriodDatesReference=" + this.calculationPeriodDatesReference +
			'}';
		}
	}
}
