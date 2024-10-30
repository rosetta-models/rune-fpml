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
import fpml.confirmation.FxFixingScheduleSequence1;
import fpml.confirmation.FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder;
import fpml.confirmation.FxFixingScheduleSequence1.FxFixingScheduleSequence1BuilderImpl;
import fpml.confirmation.FxFixingScheduleSequence1.FxFixingScheduleSequence1Impl;
import fpml.confirmation.ParametricScheduleModel;
import fpml.confirmation.meta.FxFixingScheduleSequence1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxFixingScheduleSequence1", builder=FxFixingScheduleSequence1.FxFixingScheduleSequence1BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxFixingScheduleSequence1 extends RosettaModelObject {

	FxFixingScheduleSequence1Meta metaData = new FxFixingScheduleSequence1Meta();

	/*********************** Getter Methods  ***********************/
	ParametricScheduleModel getParametricScheduleModel();
	/**
	 * The number of fixing points in the fixing schedule.
	 */
	Integer getNumberOfFixings();
	/**
	 * An explicit list of dates in the schedule. Where a conflict every existed between parametric and explicit dates, the explicit list of dates would takes precedence.
	 */
	List<Date> getFixingDate();

	/*********************** Build Methods  ***********************/
	FxFixingScheduleSequence1 build();
	
	FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder toBuilder();
	
	static FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder builder() {
		return new FxFixingScheduleSequence1.FxFixingScheduleSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFixingScheduleSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFixingScheduleSequence1> getType() {
		return FxFixingScheduleSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("parametricScheduleModel"), processor, ParametricScheduleModel.class, getParametricScheduleModel());
		processor.processBasic(path.newSubPath("numberOfFixings"), Integer.class, getNumberOfFixings(), this);
		processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFixingScheduleSequence1Builder extends FxFixingScheduleSequence1, RosettaModelObjectBuilder {
		ParametricScheduleModel.ParametricScheduleModelBuilder getOrCreateParametricScheduleModel();
		ParametricScheduleModel.ParametricScheduleModelBuilder getParametricScheduleModel();
		FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder setParametricScheduleModel(ParametricScheduleModel parametricScheduleModel);
		FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder setNumberOfFixings(Integer numberOfFixings);
		FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder addFixingDate(Date fixingDate0);
		FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder addFixingDate(Date fixingDate1, int _idx);
		FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder addFixingDate(List<Date> fixingDate2);
		FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder setFixingDate(List<Date> fixingDate3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("parametricScheduleModel"), processor, ParametricScheduleModel.ParametricScheduleModelBuilder.class, getParametricScheduleModel());
			processor.processBasic(path.newSubPath("numberOfFixings"), Integer.class, getNumberOfFixings(), this);
			processor.processBasic(path.newSubPath("fixingDate"), Date.class, getFixingDate(), this);
		}
		

		FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder prune();
	}

	/*********************** Immutable Implementation of FxFixingScheduleSequence1  ***********************/
	class FxFixingScheduleSequence1Impl implements FxFixingScheduleSequence1 {
		private final ParametricScheduleModel parametricScheduleModel;
		private final Integer numberOfFixings;
		private final List<Date> fixingDate;
		
		protected FxFixingScheduleSequence1Impl(FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder builder) {
			this.parametricScheduleModel = ofNullable(builder.getParametricScheduleModel()).map(f->f.build()).orElse(null);
			this.numberOfFixings = builder.getNumberOfFixings();
			this.fixingDate = ofNullable(builder.getFixingDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("parametricScheduleModel")
		public ParametricScheduleModel getParametricScheduleModel() {
			return parametricScheduleModel;
		}
		
		@Override
		@RosettaAttribute("numberOfFixings")
		public Integer getNumberOfFixings() {
			return numberOfFixings;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public List<Date> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		public FxFixingScheduleSequence1 build() {
			return this;
		}
		
		@Override
		public FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder toBuilder() {
			FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder builder) {
			ofNullable(getParametricScheduleModel()).ifPresent(builder::setParametricScheduleModel);
			ofNullable(getNumberOfFixings()).ifPresent(builder::setNumberOfFixings);
			ofNullable(getFixingDate()).ifPresent(builder::setFixingDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingScheduleSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(parametricScheduleModel, _that.getParametricScheduleModel())) return false;
			if (!Objects.equals(numberOfFixings, _that.getNumberOfFixings())) return false;
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parametricScheduleModel != null ? parametricScheduleModel.hashCode() : 0);
			_result = 31 * _result + (numberOfFixings != null ? numberOfFixings.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingScheduleSequence1 {" +
				"parametricScheduleModel=" + this.parametricScheduleModel + ", " +
				"numberOfFixings=" + this.numberOfFixings + ", " +
				"fixingDate=" + this.fixingDate +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFixingScheduleSequence1  ***********************/
	class FxFixingScheduleSequence1BuilderImpl implements FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder {
	
		protected ParametricScheduleModel.ParametricScheduleModelBuilder parametricScheduleModel;
		protected Integer numberOfFixings;
		protected List<Date> fixingDate = new ArrayList<>();
	
		public FxFixingScheduleSequence1BuilderImpl() {
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
		@RosettaAttribute("numberOfFixings")
		public Integer getNumberOfFixings() {
			return numberOfFixings;
		}
		
		@Override
		@RosettaAttribute("fixingDate")
		public List<Date> getFixingDate() {
			return fixingDate;
		}
		
		@Override
		@RosettaAttribute("parametricScheduleModel")
		public FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder setParametricScheduleModel(ParametricScheduleModel parametricScheduleModel) {
			this.parametricScheduleModel = parametricScheduleModel==null?null:parametricScheduleModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("numberOfFixings")
		public FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder setNumberOfFixings(Integer numberOfFixings) {
			this.numberOfFixings = numberOfFixings==null?null:numberOfFixings;
			return this;
		}
		@Override
		@RosettaAttribute("fixingDate")
		public FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder addFixingDate(Date fixingDate) {
			if (fixingDate!=null) this.fixingDate.add(fixingDate);
			return this;
		}
		
		@Override
		public FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder addFixingDate(Date fixingDate, int _idx) {
			getIndex(this.fixingDate, _idx, () -> fixingDate);
			return this;
		}
		@Override 
		public FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder addFixingDate(List<Date> fixingDates) {
			if (fixingDates != null) {
				for (Date toAdd : fixingDates) {
					this.fixingDate.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder setFixingDate(List<Date> fixingDates) {
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
		public FxFixingScheduleSequence1 build() {
			return new FxFixingScheduleSequence1.FxFixingScheduleSequence1Impl(this);
		}
		
		@Override
		public FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder prune() {
			if (parametricScheduleModel!=null && !parametricScheduleModel.prune().hasData()) parametricScheduleModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParametricScheduleModel()!=null && getParametricScheduleModel().hasData()) return true;
			if (getNumberOfFixings()!=null) return true;
			if (getFixingDate()!=null && !getFixingDate().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder o = (FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder) other;
			
			merger.mergeRosetta(getParametricScheduleModel(), o.getParametricScheduleModel(), this::setParametricScheduleModel);
			
			merger.mergeBasic(getNumberOfFixings(), o.getNumberOfFixings(), this::setNumberOfFixings);
			merger.mergeBasic(getFixingDate(), o.getFixingDate(), (Consumer<Date>) this::addFixingDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingScheduleSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(parametricScheduleModel, _that.getParametricScheduleModel())) return false;
			if (!Objects.equals(numberOfFixings, _that.getNumberOfFixings())) return false;
			if (!ListEquals.listEquals(fixingDate, _that.getFixingDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parametricScheduleModel != null ? parametricScheduleModel.hashCode() : 0);
			_result = 31 * _result + (numberOfFixings != null ? numberOfFixings.hashCode() : 0);
			_result = 31 * _result + (fixingDate != null ? fixingDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingScheduleSequence1Builder {" +
				"parametricScheduleModel=" + this.parametricScheduleModel + ", " +
				"numberOfFixings=" + this.numberOfFixings + ", " +
				"fixingDate=" + this.fixingDate +
			'}';
		}
	}
}
