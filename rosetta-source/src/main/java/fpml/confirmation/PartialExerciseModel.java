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
import fpml.confirmation.NotionalReference;
import fpml.confirmation.PartialExerciseModel;
import fpml.confirmation.PartialExerciseModel.PartialExerciseModelBuilder;
import fpml.confirmation.PartialExerciseModel.PartialExerciseModelBuilderImpl;
import fpml.confirmation.PartialExerciseModel.PartialExerciseModelImpl;
import fpml.confirmation.meta.PartialExerciseModelMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PartialExerciseModel", builder=PartialExerciseModel.PartialExerciseModelBuilderImpl.class, version="${project.version}")
public interface PartialExerciseModel extends RosettaModelObject {

	PartialExerciseModelMeta metaData = new PartialExerciseModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to the associated notional schedule defined elsewhere in the document. This element has been made optional as part of its integration in the OptionBaseExtended, because not required for the options on securities.
	 */
	List<? extends NotionalReference> getNotionalReference();
	/**
	 * A notional amount which restricts the amount of notional that can be exercised when partial exercise or multiple exercise is applicable. The integral multiple amount defines a lower limit of notional that can be exercised and also defines a unit multiple of notional that can be exercised, i.e. only integer multiples of this amount can be exercised.
	 */
	BigDecimal getIntegralMultipleAmount();
	/**
	 * The minimum notional amount that can be exercised on a given exercise date. See multipleExercise.
	 */
	BigDecimal getMinimumNotionalAmount();
	/**
	 * The minimum number of options that can be exercised on a given exercise date.
	 */
	Integer getMinimumNumberOfOptions();

	/*********************** Build Methods  ***********************/
	PartialExerciseModel build();
	
	PartialExerciseModel.PartialExerciseModelBuilder toBuilder();
	
	static PartialExerciseModel.PartialExerciseModelBuilder builder() {
		return new PartialExerciseModel.PartialExerciseModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartialExerciseModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartialExerciseModel> getType() {
		return PartialExerciseModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.class, getNotionalReference());
		processor.processBasic(path.newSubPath("integralMultipleAmount"), BigDecimal.class, getIntegralMultipleAmount(), this);
		processor.processBasic(path.newSubPath("minimumNotionalAmount"), BigDecimal.class, getMinimumNotionalAmount(), this);
		processor.processBasic(path.newSubPath("minimumNumberOfOptions"), Integer.class, getMinimumNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartialExerciseModelBuilder extends PartialExerciseModel, RosettaModelObjectBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference(int _index);
		List<? extends NotionalReference.NotionalReferenceBuilder> getNotionalReference();
		PartialExerciseModel.PartialExerciseModelBuilder addNotionalReference(NotionalReference notionalReference0);
		PartialExerciseModel.PartialExerciseModelBuilder addNotionalReference(NotionalReference notionalReference1, int _idx);
		PartialExerciseModel.PartialExerciseModelBuilder addNotionalReference(List<? extends NotionalReference> notionalReference2);
		PartialExerciseModel.PartialExerciseModelBuilder setNotionalReference(List<? extends NotionalReference> notionalReference3);
		PartialExerciseModel.PartialExerciseModelBuilder setIntegralMultipleAmount(BigDecimal integralMultipleAmount);
		PartialExerciseModel.PartialExerciseModelBuilder setMinimumNotionalAmount(BigDecimal minimumNotionalAmount);
		PartialExerciseModel.PartialExerciseModelBuilder setMinimumNumberOfOptions(Integer minimumNumberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalReference());
			processor.processBasic(path.newSubPath("integralMultipleAmount"), BigDecimal.class, getIntegralMultipleAmount(), this);
			processor.processBasic(path.newSubPath("minimumNotionalAmount"), BigDecimal.class, getMinimumNotionalAmount(), this);
			processor.processBasic(path.newSubPath("minimumNumberOfOptions"), Integer.class, getMinimumNumberOfOptions(), this);
		}
		

		PartialExerciseModel.PartialExerciseModelBuilder prune();
	}

	/*********************** Immutable Implementation of PartialExerciseModel  ***********************/
	class PartialExerciseModelImpl implements PartialExerciseModel {
		private final List<? extends NotionalReference> notionalReference;
		private final BigDecimal integralMultipleAmount;
		private final BigDecimal minimumNotionalAmount;
		private final Integer minimumNumberOfOptions;
		
		protected PartialExerciseModelImpl(PartialExerciseModel.PartialExerciseModelBuilder builder) {
			this.notionalReference = ofNullable(builder.getNotionalReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.integralMultipleAmount = builder.getIntegralMultipleAmount();
			this.minimumNotionalAmount = builder.getMinimumNotionalAmount();
			this.minimumNumberOfOptions = builder.getMinimumNumberOfOptions();
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		public List<? extends NotionalReference> getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		@RosettaAttribute("integralMultipleAmount")
		public BigDecimal getIntegralMultipleAmount() {
			return integralMultipleAmount;
		}
		
		@Override
		@RosettaAttribute("minimumNotionalAmount")
		public BigDecimal getMinimumNotionalAmount() {
			return minimumNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("minimumNumberOfOptions")
		public Integer getMinimumNumberOfOptions() {
			return minimumNumberOfOptions;
		}
		
		@Override
		public PartialExerciseModel build() {
			return this;
		}
		
		@Override
		public PartialExerciseModel.PartialExerciseModelBuilder toBuilder() {
			PartialExerciseModel.PartialExerciseModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartialExerciseModel.PartialExerciseModelBuilder builder) {
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getIntegralMultipleAmount()).ifPresent(builder::setIntegralMultipleAmount);
			ofNullable(getMinimumNotionalAmount()).ifPresent(builder::setMinimumNotionalAmount);
			ofNullable(getMinimumNumberOfOptions()).ifPresent(builder::setMinimumNumberOfOptions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartialExerciseModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(integralMultipleAmount, _that.getIntegralMultipleAmount())) return false;
			if (!Objects.equals(minimumNotionalAmount, _that.getMinimumNotionalAmount())) return false;
			if (!Objects.equals(minimumNumberOfOptions, _that.getMinimumNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (integralMultipleAmount != null ? integralMultipleAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNotionalAmount != null ? minimumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNumberOfOptions != null ? minimumNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartialExerciseModel {" +
				"notionalReference=" + this.notionalReference + ", " +
				"integralMultipleAmount=" + this.integralMultipleAmount + ", " +
				"minimumNotionalAmount=" + this.minimumNotionalAmount + ", " +
				"minimumNumberOfOptions=" + this.minimumNumberOfOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of PartialExerciseModel  ***********************/
	class PartialExerciseModelBuilderImpl implements PartialExerciseModel.PartialExerciseModelBuilder {
	
		protected List<NotionalReference.NotionalReferenceBuilder> notionalReference = new ArrayList<>();
		protected BigDecimal integralMultipleAmount;
		protected BigDecimal minimumNotionalAmount;
		protected Integer minimumNumberOfOptions;
	
		public PartialExerciseModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalReference")
		public List<? extends NotionalReference.NotionalReferenceBuilder> getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference(int _index) {
		
			if (notionalReference==null) {
				this.notionalReference = new ArrayList<>();
			}
			NotionalReference.NotionalReferenceBuilder result;
			return getIndex(notionalReference, _index, () -> {
						NotionalReference.NotionalReferenceBuilder newNotionalReference = NotionalReference.builder();
						return newNotionalReference;
					});
		}
		
		@Override
		@RosettaAttribute("integralMultipleAmount")
		public BigDecimal getIntegralMultipleAmount() {
			return integralMultipleAmount;
		}
		
		@Override
		@RosettaAttribute("minimumNotionalAmount")
		public BigDecimal getMinimumNotionalAmount() {
			return minimumNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("minimumNumberOfOptions")
		public Integer getMinimumNumberOfOptions() {
			return minimumNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		public PartialExerciseModel.PartialExerciseModelBuilder addNotionalReference(NotionalReference notionalReference) {
			if (notionalReference!=null) this.notionalReference.add(notionalReference.toBuilder());
			return this;
		}
		
		@Override
		public PartialExerciseModel.PartialExerciseModelBuilder addNotionalReference(NotionalReference notionalReference, int _idx) {
			getIndex(this.notionalReference, _idx, () -> notionalReference.toBuilder());
			return this;
		}
		@Override 
		public PartialExerciseModel.PartialExerciseModelBuilder addNotionalReference(List<? extends NotionalReference> notionalReferences) {
			if (notionalReferences != null) {
				for (NotionalReference toAdd : notionalReferences) {
					this.notionalReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartialExerciseModel.PartialExerciseModelBuilder setNotionalReference(List<? extends NotionalReference> notionalReferences) {
			if (notionalReferences == null)  {
				this.notionalReference = new ArrayList<>();
			}
			else {
				this.notionalReference = notionalReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("integralMultipleAmount")
		public PartialExerciseModel.PartialExerciseModelBuilder setIntegralMultipleAmount(BigDecimal integralMultipleAmount) {
			this.integralMultipleAmount = integralMultipleAmount==null?null:integralMultipleAmount;
			return this;
		}
		@Override
		@RosettaAttribute("minimumNotionalAmount")
		public PartialExerciseModel.PartialExerciseModelBuilder setMinimumNotionalAmount(BigDecimal minimumNotionalAmount) {
			this.minimumNotionalAmount = minimumNotionalAmount==null?null:minimumNotionalAmount;
			return this;
		}
		@Override
		@RosettaAttribute("minimumNumberOfOptions")
		public PartialExerciseModel.PartialExerciseModelBuilder setMinimumNumberOfOptions(Integer minimumNumberOfOptions) {
			this.minimumNumberOfOptions = minimumNumberOfOptions==null?null:minimumNumberOfOptions;
			return this;
		}
		
		@Override
		public PartialExerciseModel build() {
			return new PartialExerciseModel.PartialExerciseModelImpl(this);
		}
		
		@Override
		public PartialExerciseModel.PartialExerciseModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartialExerciseModel.PartialExerciseModelBuilder prune() {
			notionalReference = notionalReference.stream().filter(b->b!=null).<NotionalReference.NotionalReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalReference()!=null && getNotionalReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIntegralMultipleAmount()!=null) return true;
			if (getMinimumNotionalAmount()!=null) return true;
			if (getMinimumNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartialExerciseModel.PartialExerciseModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartialExerciseModel.PartialExerciseModelBuilder o = (PartialExerciseModel.PartialExerciseModelBuilder) other;
			
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::getOrCreateNotionalReference);
			
			merger.mergeBasic(getIntegralMultipleAmount(), o.getIntegralMultipleAmount(), this::setIntegralMultipleAmount);
			merger.mergeBasic(getMinimumNotionalAmount(), o.getMinimumNotionalAmount(), this::setMinimumNotionalAmount);
			merger.mergeBasic(getMinimumNumberOfOptions(), o.getMinimumNumberOfOptions(), this::setMinimumNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartialExerciseModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(integralMultipleAmount, _that.getIntegralMultipleAmount())) return false;
			if (!Objects.equals(minimumNotionalAmount, _that.getMinimumNotionalAmount())) return false;
			if (!Objects.equals(minimumNumberOfOptions, _that.getMinimumNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (integralMultipleAmount != null ? integralMultipleAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNotionalAmount != null ? minimumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNumberOfOptions != null ? minimumNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartialExerciseModelBuilder {" +
				"notionalReference=" + this.notionalReference + ", " +
				"integralMultipleAmount=" + this.integralMultipleAmount + ", " +
				"minimumNotionalAmount=" + this.minimumNotionalAmount + ", " +
				"minimumNumberOfOptions=" + this.minimumNumberOfOptions +
			'}';
		}
	}
}
