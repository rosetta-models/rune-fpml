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
import fpml.confirmation.OptionEvent;
import fpml.confirmation.OptionExercise;
import fpml.confirmation.OptionExpiry;
import fpml.confirmation.OptionsEventsBaseModel;
import fpml.confirmation.OptionsEventsBaseModel.OptionsEventsBaseModelBuilder;
import fpml.confirmation.OptionsEventsBaseModel.OptionsEventsBaseModelBuilderImpl;
import fpml.confirmation.OptionsEventsBaseModel.OptionsEventsBaseModelImpl;
import fpml.confirmation.meta.OptionsEventsBaseModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Choice between options related events.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionsEventsBaseModel", builder=OptionsEventsBaseModel.OptionsEventsBaseModelBuilderImpl.class, version="${project.version}")
public interface OptionsEventsBaseModel extends RosettaModelObject {

	OptionsEventsBaseModelMeta metaData = new OptionsEventsBaseModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A structure describing an option exercise event. The optionExercise event supports partial exercise (specify the number of options or amount to exercise), full exercise (use fullExercise flag), as well as the option to request options not to be exercised.
	 */
	OptionExercise getOptionExercise();
	/**
	 * A structure describing an option expiring event (i.e. passing its last exercise time and becoming worthless.)
	 */
	List<? extends OptionExpiry> getOptionExpiry();
	/**
	 * A structure describing knock in, knock out, touch and no touch events.
	 */
	OptionEvent getOptionEvent();

	/*********************** Build Methods  ***********************/
	OptionsEventsBaseModel build();
	
	OptionsEventsBaseModel.OptionsEventsBaseModelBuilder toBuilder();
	
	static OptionsEventsBaseModel.OptionsEventsBaseModelBuilder builder() {
		return new OptionsEventsBaseModel.OptionsEventsBaseModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionsEventsBaseModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionsEventsBaseModel> getType() {
		return OptionsEventsBaseModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.class, getOptionExercise());
		processRosetta(path.newSubPath("optionExpiry"), processor, OptionExpiry.class, getOptionExpiry());
		processRosetta(path.newSubPath("optionEvent"), processor, OptionEvent.class, getOptionEvent());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionsEventsBaseModelBuilder extends OptionsEventsBaseModel, RosettaModelObjectBuilder {
		OptionExercise.OptionExerciseBuilder getOrCreateOptionExercise();
		OptionExercise.OptionExerciseBuilder getOptionExercise();
		OptionExpiry.OptionExpiryBuilder getOrCreateOptionExpiry(int _index);
		List<? extends OptionExpiry.OptionExpiryBuilder> getOptionExpiry();
		OptionEvent.OptionEventBuilder getOrCreateOptionEvent();
		OptionEvent.OptionEventBuilder getOptionEvent();
		OptionsEventsBaseModel.OptionsEventsBaseModelBuilder setOptionExercise(OptionExercise optionExercise);
		OptionsEventsBaseModel.OptionsEventsBaseModelBuilder addOptionExpiry(OptionExpiry optionExpiry0);
		OptionsEventsBaseModel.OptionsEventsBaseModelBuilder addOptionExpiry(OptionExpiry optionExpiry1, int _idx);
		OptionsEventsBaseModel.OptionsEventsBaseModelBuilder addOptionExpiry(List<? extends OptionExpiry> optionExpiry2);
		OptionsEventsBaseModel.OptionsEventsBaseModelBuilder setOptionExpiry(List<? extends OptionExpiry> optionExpiry3);
		OptionsEventsBaseModel.OptionsEventsBaseModelBuilder setOptionEvent(OptionEvent optionEvent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("optionExercise"), processor, OptionExercise.OptionExerciseBuilder.class, getOptionExercise());
			processRosetta(path.newSubPath("optionExpiry"), processor, OptionExpiry.OptionExpiryBuilder.class, getOptionExpiry());
			processRosetta(path.newSubPath("optionEvent"), processor, OptionEvent.OptionEventBuilder.class, getOptionEvent());
		}
		

		OptionsEventsBaseModel.OptionsEventsBaseModelBuilder prune();
	}

	/*********************** Immutable Implementation of OptionsEventsBaseModel  ***********************/
	class OptionsEventsBaseModelImpl implements OptionsEventsBaseModel {
		private final OptionExercise optionExercise;
		private final List<? extends OptionExpiry> optionExpiry;
		private final OptionEvent optionEvent;
		
		protected OptionsEventsBaseModelImpl(OptionsEventsBaseModel.OptionsEventsBaseModelBuilder builder) {
			this.optionExercise = ofNullable(builder.getOptionExercise()).map(f->f.build()).orElse(null);
			this.optionExpiry = ofNullable(builder.getOptionExpiry()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.optionEvent = ofNullable(builder.getOptionEvent()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionExercise")
		public OptionExercise getOptionExercise() {
			return optionExercise;
		}
		
		@Override
		@RosettaAttribute("optionExpiry")
		public List<? extends OptionExpiry> getOptionExpiry() {
			return optionExpiry;
		}
		
		@Override
		@RosettaAttribute("optionEvent")
		public OptionEvent getOptionEvent() {
			return optionEvent;
		}
		
		@Override
		public OptionsEventsBaseModel build() {
			return this;
		}
		
		@Override
		public OptionsEventsBaseModel.OptionsEventsBaseModelBuilder toBuilder() {
			OptionsEventsBaseModel.OptionsEventsBaseModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionsEventsBaseModel.OptionsEventsBaseModelBuilder builder) {
			ofNullable(getOptionExercise()).ifPresent(builder::setOptionExercise);
			ofNullable(getOptionExpiry()).ifPresent(builder::setOptionExpiry);
			ofNullable(getOptionEvent()).ifPresent(builder::setOptionEvent);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionsEventsBaseModel _that = getType().cast(o);
		
			if (!Objects.equals(optionExercise, _that.getOptionExercise())) return false;
			if (!ListEquals.listEquals(optionExpiry, _that.getOptionExpiry())) return false;
			if (!Objects.equals(optionEvent, _that.getOptionEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionExercise != null ? optionExercise.hashCode() : 0);
			_result = 31 * _result + (optionExpiry != null ? optionExpiry.hashCode() : 0);
			_result = 31 * _result + (optionEvent != null ? optionEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionsEventsBaseModel {" +
				"optionExercise=" + this.optionExercise + ", " +
				"optionExpiry=" + this.optionExpiry + ", " +
				"optionEvent=" + this.optionEvent +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionsEventsBaseModel  ***********************/
	class OptionsEventsBaseModelBuilderImpl implements OptionsEventsBaseModel.OptionsEventsBaseModelBuilder {
	
		protected OptionExercise.OptionExerciseBuilder optionExercise;
		protected List<OptionExpiry.OptionExpiryBuilder> optionExpiry = new ArrayList<>();
		protected OptionEvent.OptionEventBuilder optionEvent;
	
		public OptionsEventsBaseModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionExercise")
		public OptionExercise.OptionExerciseBuilder getOptionExercise() {
			return optionExercise;
		}
		
		@Override
		public OptionExercise.OptionExerciseBuilder getOrCreateOptionExercise() {
			OptionExercise.OptionExerciseBuilder result;
			if (optionExercise!=null) {
				result = optionExercise;
			}
			else {
				result = optionExercise = OptionExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionExpiry")
		public List<? extends OptionExpiry.OptionExpiryBuilder> getOptionExpiry() {
			return optionExpiry;
		}
		
		public OptionExpiry.OptionExpiryBuilder getOrCreateOptionExpiry(int _index) {
		
			if (optionExpiry==null) {
				this.optionExpiry = new ArrayList<>();
			}
			OptionExpiry.OptionExpiryBuilder result;
			return getIndex(optionExpiry, _index, () -> {
						OptionExpiry.OptionExpiryBuilder newOptionExpiry = OptionExpiry.builder();
						return newOptionExpiry;
					});
		}
		
		@Override
		@RosettaAttribute("optionEvent")
		public OptionEvent.OptionEventBuilder getOptionEvent() {
			return optionEvent;
		}
		
		@Override
		public OptionEvent.OptionEventBuilder getOrCreateOptionEvent() {
			OptionEvent.OptionEventBuilder result;
			if (optionEvent!=null) {
				result = optionEvent;
			}
			else {
				result = optionEvent = OptionEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionExercise")
		public OptionsEventsBaseModel.OptionsEventsBaseModelBuilder setOptionExercise(OptionExercise optionExercise) {
			this.optionExercise = optionExercise==null?null:optionExercise.toBuilder();
			return this;
		}
		@Override
		public OptionsEventsBaseModel.OptionsEventsBaseModelBuilder addOptionExpiry(OptionExpiry optionExpiry) {
			if (optionExpiry!=null) this.optionExpiry.add(optionExpiry.toBuilder());
			return this;
		}
		
		@Override
		public OptionsEventsBaseModel.OptionsEventsBaseModelBuilder addOptionExpiry(OptionExpiry optionExpiry, int _idx) {
			getIndex(this.optionExpiry, _idx, () -> optionExpiry.toBuilder());
			return this;
		}
		@Override 
		public OptionsEventsBaseModel.OptionsEventsBaseModelBuilder addOptionExpiry(List<? extends OptionExpiry> optionExpirys) {
			if (optionExpirys != null) {
				for (OptionExpiry toAdd : optionExpirys) {
					this.optionExpiry.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("optionExpiry")
		public OptionsEventsBaseModel.OptionsEventsBaseModelBuilder setOptionExpiry(List<? extends OptionExpiry> optionExpirys) {
			if (optionExpirys == null)  {
				this.optionExpiry = new ArrayList<>();
			}
			else {
				this.optionExpiry = optionExpirys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("optionEvent")
		public OptionsEventsBaseModel.OptionsEventsBaseModelBuilder setOptionEvent(OptionEvent optionEvent) {
			this.optionEvent = optionEvent==null?null:optionEvent.toBuilder();
			return this;
		}
		
		@Override
		public OptionsEventsBaseModel build() {
			return new OptionsEventsBaseModel.OptionsEventsBaseModelImpl(this);
		}
		
		@Override
		public OptionsEventsBaseModel.OptionsEventsBaseModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionsEventsBaseModel.OptionsEventsBaseModelBuilder prune() {
			if (optionExercise!=null && !optionExercise.prune().hasData()) optionExercise = null;
			optionExpiry = optionExpiry.stream().filter(b->b!=null).<OptionExpiry.OptionExpiryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (optionEvent!=null && !optionEvent.prune().hasData()) optionEvent = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOptionExercise()!=null && getOptionExercise().hasData()) return true;
			if (getOptionExpiry()!=null && getOptionExpiry().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOptionEvent()!=null && getOptionEvent().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionsEventsBaseModel.OptionsEventsBaseModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionsEventsBaseModel.OptionsEventsBaseModelBuilder o = (OptionsEventsBaseModel.OptionsEventsBaseModelBuilder) other;
			
			merger.mergeRosetta(getOptionExercise(), o.getOptionExercise(), this::setOptionExercise);
			merger.mergeRosetta(getOptionExpiry(), o.getOptionExpiry(), this::getOrCreateOptionExpiry);
			merger.mergeRosetta(getOptionEvent(), o.getOptionEvent(), this::setOptionEvent);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionsEventsBaseModel _that = getType().cast(o);
		
			if (!Objects.equals(optionExercise, _that.getOptionExercise())) return false;
			if (!ListEquals.listEquals(optionExpiry, _that.getOptionExpiry())) return false;
			if (!Objects.equals(optionEvent, _that.getOptionEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionExercise != null ? optionExercise.hashCode() : 0);
			_result = 31 * _result + (optionExpiry != null ? optionExpiry.hashCode() : 0);
			_result = 31 * _result + (optionEvent != null ? optionEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionsEventsBaseModelBuilder {" +
				"optionExercise=" + this.optionExercise + ", " +
				"optionExpiry=" + this.optionExpiry + ", " +
				"optionEvent=" + this.optionEvent +
			'}';
		}
	}
}
