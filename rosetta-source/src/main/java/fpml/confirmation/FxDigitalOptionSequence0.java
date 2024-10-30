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
import fpml.confirmation.FxDigitalAmericanExercise;
import fpml.confirmation.FxDigitalOptionSequence0;
import fpml.confirmation.FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder;
import fpml.confirmation.FxDigitalOptionSequence0.FxDigitalOptionSequence0BuilderImpl;
import fpml.confirmation.FxDigitalOptionSequence0.FxDigitalOptionSequence0Impl;
import fpml.confirmation.FxTouch;
import fpml.confirmation.meta.FxDigitalOptionSequence0Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxDigitalOptionSequence0", builder=FxDigitalOptionSequence0.FxDigitalOptionSequence0BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxDigitalOptionSequence0 extends RosettaModelObject {

	FxDigitalOptionSequence0Meta metaData = new FxDigitalOptionSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parameters for defining the exercise period for an American style option.
	 */
	FxDigitalAmericanExercise getAmericanExercise();
	/**
	 * Defines one or more conditions underwhich the option will payout if exercisable.
	 */
	List<? extends FxTouch> getTouch();

	/*********************** Build Methods  ***********************/
	FxDigitalOptionSequence0 build();
	
	FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder toBuilder();
	
	static FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder builder() {
		return new FxDigitalOptionSequence0.FxDigitalOptionSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDigitalOptionSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxDigitalOptionSequence0> getType() {
		return FxDigitalOptionSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("americanExercise"), processor, FxDigitalAmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("touch"), processor, FxTouch.class, getTouch());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDigitalOptionSequence0Builder extends FxDigitalOptionSequence0, RosettaModelObjectBuilder {
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder getOrCreateAmericanExercise();
		FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder getAmericanExercise();
		FxTouch.FxTouchBuilder getOrCreateTouch(int _index);
		List<? extends FxTouch.FxTouchBuilder> getTouch();
		FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder setAmericanExercise(FxDigitalAmericanExercise americanExercise);
		FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder addTouch(FxTouch touch0);
		FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder addTouch(FxTouch touch1, int _idx);
		FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder addTouch(List<? extends FxTouch> touch2);
		FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder setTouch(List<? extends FxTouch> touch3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("americanExercise"), processor, FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("touch"), processor, FxTouch.FxTouchBuilder.class, getTouch());
		}
		

		FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder prune();
	}

	/*********************** Immutable Implementation of FxDigitalOptionSequence0  ***********************/
	class FxDigitalOptionSequence0Impl implements FxDigitalOptionSequence0 {
		private final FxDigitalAmericanExercise americanExercise;
		private final List<? extends FxTouch> touch;
		
		protected FxDigitalOptionSequence0Impl(FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder builder) {
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.touch = ofNullable(builder.getTouch()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("americanExercise")
		public FxDigitalAmericanExercise getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		@RosettaAttribute("touch")
		public List<? extends FxTouch> getTouch() {
			return touch;
		}
		
		@Override
		public FxDigitalOptionSequence0 build() {
			return this;
		}
		
		@Override
		public FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder toBuilder() {
			FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder builder) {
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getTouch()).ifPresent(builder::setTouch);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDigitalOptionSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!ListEquals.listEquals(touch, _that.getTouch())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (touch != null ? touch.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDigitalOptionSequence0 {" +
				"americanExercise=" + this.americanExercise + ", " +
				"touch=" + this.touch +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDigitalOptionSequence0  ***********************/
	class FxDigitalOptionSequence0BuilderImpl implements FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder {
	
		protected FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder americanExercise;
		protected List<FxTouch.FxTouchBuilder> touch = new ArrayList<>();
	
		public FxDigitalOptionSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("americanExercise")
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder getOrCreateAmericanExercise() {
			FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder result;
			if (americanExercise!=null) {
				result = americanExercise;
			}
			else {
				result = americanExercise = FxDigitalAmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("touch")
		public List<? extends FxTouch.FxTouchBuilder> getTouch() {
			return touch;
		}
		
		@Override
		public FxTouch.FxTouchBuilder getOrCreateTouch(int _index) {
		
			if (touch==null) {
				this.touch = new ArrayList<>();
			}
			FxTouch.FxTouchBuilder result;
			return getIndex(touch, _index, () -> {
						FxTouch.FxTouchBuilder newTouch = FxTouch.builder();
						return newTouch;
					});
		}
		
		@Override
		@RosettaAttribute("americanExercise")
		public FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder setAmericanExercise(FxDigitalAmericanExercise americanExercise) {
			this.americanExercise = americanExercise==null?null:americanExercise.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("touch")
		public FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder addTouch(FxTouch touch) {
			if (touch!=null) this.touch.add(touch.toBuilder());
			return this;
		}
		
		@Override
		public FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder addTouch(FxTouch touch, int _idx) {
			getIndex(this.touch, _idx, () -> touch.toBuilder());
			return this;
		}
		@Override 
		public FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder addTouch(List<? extends FxTouch> touchs) {
			if (touchs != null) {
				for (FxTouch toAdd : touchs) {
					this.touch.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder setTouch(List<? extends FxTouch> touchs) {
			if (touchs == null)  {
				this.touch = new ArrayList<>();
			}
			else {
				this.touch = touchs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxDigitalOptionSequence0 build() {
			return new FxDigitalOptionSequence0.FxDigitalOptionSequence0Impl(this);
		}
		
		@Override
		public FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder prune() {
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			touch = touch.stream().filter(b->b!=null).<FxTouch.FxTouchBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getTouch()!=null && getTouch().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder o = (FxDigitalOptionSequence0.FxDigitalOptionSequence0Builder) other;
			
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getTouch(), o.getTouch(), this::getOrCreateTouch);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDigitalOptionSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!ListEquals.listEquals(touch, _that.getTouch())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (touch != null ? touch.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDigitalOptionSequence0Builder {" +
				"americanExercise=" + this.americanExercise + ", " +
				"touch=" + this.touch +
			'}';
		}
	}
}
