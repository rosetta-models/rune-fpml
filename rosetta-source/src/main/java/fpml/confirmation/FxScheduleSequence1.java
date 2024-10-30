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
import fpml.confirmation.FxDateOffset;
import fpml.confirmation.FxScheduleSequence1;
import fpml.confirmation.FxScheduleSequence1.FxScheduleSequence1Builder;
import fpml.confirmation.FxScheduleSequence1.FxScheduleSequence1BuilderImpl;
import fpml.confirmation.FxScheduleSequence1.FxScheduleSequence1Impl;
import fpml.confirmation.ParametricScheduleModel;
import fpml.confirmation.meta.FxScheduleSequence1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxScheduleSequence1", builder=FxScheduleSequence1.FxScheduleSequence1BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxScheduleSequence1 extends RosettaModelObject {

	FxScheduleSequence1Meta metaData = new FxScheduleSequence1Meta();

	/*********************** Getter Methods  ***********************/
	ParametricScheduleModel getParametricScheduleModel();
	/**
	 * The representation of the schedule as an offset relative to another schedule. For example, the settlement schedule may be relative to the expiry schedule by an FxForward offset.
	 */
	FxDateOffset getDateOffset();
	/**
	 * List of schedule dates. These dates have been subject to adjustments based on the dateAdjustments structure.
	 */
	List<Date> getAdjustedDate();

	/*********************** Build Methods  ***********************/
	FxScheduleSequence1 build();
	
	FxScheduleSequence1.FxScheduleSequence1Builder toBuilder();
	
	static FxScheduleSequence1.FxScheduleSequence1Builder builder() {
		return new FxScheduleSequence1.FxScheduleSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxScheduleSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxScheduleSequence1> getType() {
		return FxScheduleSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("parametricScheduleModel"), processor, ParametricScheduleModel.class, getParametricScheduleModel());
		processRosetta(path.newSubPath("dateOffset"), processor, FxDateOffset.class, getDateOffset());
		processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxScheduleSequence1Builder extends FxScheduleSequence1, RosettaModelObjectBuilder {
		ParametricScheduleModel.ParametricScheduleModelBuilder getOrCreateParametricScheduleModel();
		ParametricScheduleModel.ParametricScheduleModelBuilder getParametricScheduleModel();
		FxDateOffset.FxDateOffsetBuilder getOrCreateDateOffset();
		FxDateOffset.FxDateOffsetBuilder getDateOffset();
		FxScheduleSequence1.FxScheduleSequence1Builder setParametricScheduleModel(ParametricScheduleModel parametricScheduleModel);
		FxScheduleSequence1.FxScheduleSequence1Builder setDateOffset(FxDateOffset dateOffset);
		FxScheduleSequence1.FxScheduleSequence1Builder addAdjustedDate(Date adjustedDate0);
		FxScheduleSequence1.FxScheduleSequence1Builder addAdjustedDate(Date adjustedDate1, int _idx);
		FxScheduleSequence1.FxScheduleSequence1Builder addAdjustedDate(List<Date> adjustedDate2);
		FxScheduleSequence1.FxScheduleSequence1Builder setAdjustedDate(List<Date> adjustedDate3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("parametricScheduleModel"), processor, ParametricScheduleModel.ParametricScheduleModelBuilder.class, getParametricScheduleModel());
			processRosetta(path.newSubPath("dateOffset"), processor, FxDateOffset.FxDateOffsetBuilder.class, getDateOffset());
			processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
		}
		

		FxScheduleSequence1.FxScheduleSequence1Builder prune();
	}

	/*********************** Immutable Implementation of FxScheduleSequence1  ***********************/
	class FxScheduleSequence1Impl implements FxScheduleSequence1 {
		private final ParametricScheduleModel parametricScheduleModel;
		private final FxDateOffset dateOffset;
		private final List<Date> adjustedDate;
		
		protected FxScheduleSequence1Impl(FxScheduleSequence1.FxScheduleSequence1Builder builder) {
			this.parametricScheduleModel = ofNullable(builder.getParametricScheduleModel()).map(f->f.build()).orElse(null);
			this.dateOffset = ofNullable(builder.getDateOffset()).map(f->f.build()).orElse(null);
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("parametricScheduleModel")
		public ParametricScheduleModel getParametricScheduleModel() {
			return parametricScheduleModel;
		}
		
		@Override
		@RosettaAttribute("dateOffset")
		public FxDateOffset getDateOffset() {
			return dateOffset;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		public List<Date> getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public FxScheduleSequence1 build() {
			return this;
		}
		
		@Override
		public FxScheduleSequence1.FxScheduleSequence1Builder toBuilder() {
			FxScheduleSequence1.FxScheduleSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxScheduleSequence1.FxScheduleSequence1Builder builder) {
			ofNullable(getParametricScheduleModel()).ifPresent(builder::setParametricScheduleModel);
			ofNullable(getDateOffset()).ifPresent(builder::setDateOffset);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxScheduleSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(parametricScheduleModel, _that.getParametricScheduleModel())) return false;
			if (!Objects.equals(dateOffset, _that.getDateOffset())) return false;
			if (!ListEquals.listEquals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parametricScheduleModel != null ? parametricScheduleModel.hashCode() : 0);
			_result = 31 * _result + (dateOffset != null ? dateOffset.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxScheduleSequence1 {" +
				"parametricScheduleModel=" + this.parametricScheduleModel + ", " +
				"dateOffset=" + this.dateOffset + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxScheduleSequence1  ***********************/
	class FxScheduleSequence1BuilderImpl implements FxScheduleSequence1.FxScheduleSequence1Builder {
	
		protected ParametricScheduleModel.ParametricScheduleModelBuilder parametricScheduleModel;
		protected FxDateOffset.FxDateOffsetBuilder dateOffset;
		protected List<Date> adjustedDate = new ArrayList<>();
	
		public FxScheduleSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("parametricScheduleModel")
		public ParametricScheduleModel.ParametricScheduleModelBuilder getParametricScheduleModel() {
			return parametricScheduleModel;
		}
		
		@Override
		public ParametricScheduleModel.ParametricScheduleModelBuilder getOrCreateParametricScheduleModel() {
			ParametricScheduleModel.ParametricScheduleModelBuilder result;
			if (parametricScheduleModel!=null) {
				result = parametricScheduleModel;
			}
			else {
				result = parametricScheduleModel = ParametricScheduleModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateOffset")
		public FxDateOffset.FxDateOffsetBuilder getDateOffset() {
			return dateOffset;
		}
		
		@Override
		public FxDateOffset.FxDateOffsetBuilder getOrCreateDateOffset() {
			FxDateOffset.FxDateOffsetBuilder result;
			if (dateOffset!=null) {
				result = dateOffset;
			}
			else {
				result = dateOffset = FxDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		public List<Date> getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		@RosettaAttribute("parametricScheduleModel")
		public FxScheduleSequence1.FxScheduleSequence1Builder setParametricScheduleModel(ParametricScheduleModel parametricScheduleModel) {
			this.parametricScheduleModel = parametricScheduleModel==null?null:parametricScheduleModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateOffset")
		public FxScheduleSequence1.FxScheduleSequence1Builder setDateOffset(FxDateOffset dateOffset) {
			this.dateOffset = dateOffset==null?null:dateOffset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustedDate")
		public FxScheduleSequence1.FxScheduleSequence1Builder addAdjustedDate(Date adjustedDate) {
			if (adjustedDate!=null) this.adjustedDate.add(adjustedDate);
			return this;
		}
		
		@Override
		public FxScheduleSequence1.FxScheduleSequence1Builder addAdjustedDate(Date adjustedDate, int _idx) {
			getIndex(this.adjustedDate, _idx, () -> adjustedDate);
			return this;
		}
		@Override 
		public FxScheduleSequence1.FxScheduleSequence1Builder addAdjustedDate(List<Date> adjustedDates) {
			if (adjustedDates != null) {
				for (Date toAdd : adjustedDates) {
					this.adjustedDate.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public FxScheduleSequence1.FxScheduleSequence1Builder setAdjustedDate(List<Date> adjustedDates) {
			if (adjustedDates == null)  {
				this.adjustedDate = new ArrayList<>();
			}
			else {
				this.adjustedDate = adjustedDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FxScheduleSequence1 build() {
			return new FxScheduleSequence1.FxScheduleSequence1Impl(this);
		}
		
		@Override
		public FxScheduleSequence1.FxScheduleSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxScheduleSequence1.FxScheduleSequence1Builder prune() {
			if (parametricScheduleModel!=null && !parametricScheduleModel.prune().hasData()) parametricScheduleModel = null;
			if (dateOffset!=null && !dateOffset.prune().hasData()) dateOffset = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParametricScheduleModel()!=null && getParametricScheduleModel().hasData()) return true;
			if (getDateOffset()!=null && getDateOffset().hasData()) return true;
			if (getAdjustedDate()!=null && !getAdjustedDate().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxScheduleSequence1.FxScheduleSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxScheduleSequence1.FxScheduleSequence1Builder o = (FxScheduleSequence1.FxScheduleSequence1Builder) other;
			
			merger.mergeRosetta(getParametricScheduleModel(), o.getParametricScheduleModel(), this::setParametricScheduleModel);
			merger.mergeRosetta(getDateOffset(), o.getDateOffset(), this::setDateOffset);
			
			merger.mergeBasic(getAdjustedDate(), o.getAdjustedDate(), (Consumer<Date>) this::addAdjustedDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxScheduleSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(parametricScheduleModel, _that.getParametricScheduleModel())) return false;
			if (!Objects.equals(dateOffset, _that.getDateOffset())) return false;
			if (!ListEquals.listEquals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parametricScheduleModel != null ? parametricScheduleModel.hashCode() : 0);
			_result = 31 * _result + (dateOffset != null ? dateOffset.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxScheduleSequence1Builder {" +
				"parametricScheduleModel=" + this.parametricScheduleModel + ", " +
				"dateOffset=" + this.dateOffset + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}';
		}
	}
}
