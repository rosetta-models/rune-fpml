package fpml.confirmation;

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
import fpml.confirmation.ParametricScheduleModel;
import fpml.confirmation.ParametricScheduleModel.ParametricScheduleModelBuilder;
import fpml.confirmation.ParametricScheduleModel.ParametricScheduleModelBuilderImpl;
import fpml.confirmation.ParametricScheduleModel.ParametricScheduleModelImpl;
import fpml.confirmation.ParametricScheduleModelSequence0;
import fpml.confirmation.ParametricScheduleModelSequence1;
import fpml.confirmation.ParametricScheduleModelSequence2;
import fpml.confirmation.meta.ParametricScheduleModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The schedule defined by the set of parameters to be able to calculate the schedule of adjusted date. The combination of the [start/endDate + dayType + businessCenters] will be used only to represent a daily schedule and the combination of [start/endDate + observationFrequency + dateAdjustments] for parametric representation of the schedules other than daily schedule.
 * @version ${project.version}
 */
@RosettaDataType(value="ParametricScheduleModel", builder=ParametricScheduleModel.ParametricScheduleModelBuilderImpl.class, version="${project.version}")
public interface ParametricScheduleModel extends RosettaModelObject {

	ParametricScheduleModelMeta metaData = new ParametricScheduleModelMeta();

	/*********************** Getter Methods  ***********************/
	ParametricScheduleModelSequence0 getParametricScheduleModelSequence0();
	/**
	 * End of the schedule.
	 */
	Date getEndDate();
	ParametricScheduleModelSequence1 getParametricScheduleModelSequence1();
	ParametricScheduleModelSequence2 getParametricScheduleModelSequence2();

	/*********************** Build Methods  ***********************/
	ParametricScheduleModel build();
	
	ParametricScheduleModel.ParametricScheduleModelBuilder toBuilder();
	
	static ParametricScheduleModel.ParametricScheduleModelBuilder builder() {
		return new ParametricScheduleModel.ParametricScheduleModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ParametricScheduleModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ParametricScheduleModel> getType() {
		return ParametricScheduleModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("parametricScheduleModelSequence0"), processor, ParametricScheduleModelSequence0.class, getParametricScheduleModelSequence0());
		processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
		processRosetta(path.newSubPath("parametricScheduleModelSequence1"), processor, ParametricScheduleModelSequence1.class, getParametricScheduleModelSequence1());
		processRosetta(path.newSubPath("parametricScheduleModelSequence2"), processor, ParametricScheduleModelSequence2.class, getParametricScheduleModelSequence2());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ParametricScheduleModelBuilder extends ParametricScheduleModel, RosettaModelObjectBuilder {
		ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder getOrCreateParametricScheduleModelSequence0();
		ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder getParametricScheduleModelSequence0();
		ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder getOrCreateParametricScheduleModelSequence1();
		ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder getParametricScheduleModelSequence1();
		ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder getOrCreateParametricScheduleModelSequence2();
		ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder getParametricScheduleModelSequence2();
		ParametricScheduleModel.ParametricScheduleModelBuilder setParametricScheduleModelSequence0(ParametricScheduleModelSequence0 parametricScheduleModelSequence0);
		ParametricScheduleModel.ParametricScheduleModelBuilder setEndDate(Date endDate);
		ParametricScheduleModel.ParametricScheduleModelBuilder setParametricScheduleModelSequence1(ParametricScheduleModelSequence1 parametricScheduleModelSequence1);
		ParametricScheduleModel.ParametricScheduleModelBuilder setParametricScheduleModelSequence2(ParametricScheduleModelSequence2 parametricScheduleModelSequence2);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("parametricScheduleModelSequence0"), processor, ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder.class, getParametricScheduleModelSequence0());
			processor.processBasic(path.newSubPath("endDate"), Date.class, getEndDate(), this);
			processRosetta(path.newSubPath("parametricScheduleModelSequence1"), processor, ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder.class, getParametricScheduleModelSequence1());
			processRosetta(path.newSubPath("parametricScheduleModelSequence2"), processor, ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder.class, getParametricScheduleModelSequence2());
		}
		

		ParametricScheduleModel.ParametricScheduleModelBuilder prune();
	}

	/*********************** Immutable Implementation of ParametricScheduleModel  ***********************/
	class ParametricScheduleModelImpl implements ParametricScheduleModel {
		private final ParametricScheduleModelSequence0 parametricScheduleModelSequence0;
		private final Date endDate;
		private final ParametricScheduleModelSequence1 parametricScheduleModelSequence1;
		private final ParametricScheduleModelSequence2 parametricScheduleModelSequence2;
		
		protected ParametricScheduleModelImpl(ParametricScheduleModel.ParametricScheduleModelBuilder builder) {
			this.parametricScheduleModelSequence0 = ofNullable(builder.getParametricScheduleModelSequence0()).map(f->f.build()).orElse(null);
			this.endDate = builder.getEndDate();
			this.parametricScheduleModelSequence1 = ofNullable(builder.getParametricScheduleModelSequence1()).map(f->f.build()).orElse(null);
			this.parametricScheduleModelSequence2 = ofNullable(builder.getParametricScheduleModelSequence2()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("parametricScheduleModelSequence0")
		public ParametricScheduleModelSequence0 getParametricScheduleModelSequence0() {
			return parametricScheduleModelSequence0;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("parametricScheduleModelSequence1")
		public ParametricScheduleModelSequence1 getParametricScheduleModelSequence1() {
			return parametricScheduleModelSequence1;
		}
		
		@Override
		@RosettaAttribute("parametricScheduleModelSequence2")
		public ParametricScheduleModelSequence2 getParametricScheduleModelSequence2() {
			return parametricScheduleModelSequence2;
		}
		
		@Override
		public ParametricScheduleModel build() {
			return this;
		}
		
		@Override
		public ParametricScheduleModel.ParametricScheduleModelBuilder toBuilder() {
			ParametricScheduleModel.ParametricScheduleModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ParametricScheduleModel.ParametricScheduleModelBuilder builder) {
			ofNullable(getParametricScheduleModelSequence0()).ifPresent(builder::setParametricScheduleModelSequence0);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getParametricScheduleModelSequence1()).ifPresent(builder::setParametricScheduleModelSequence1);
			ofNullable(getParametricScheduleModelSequence2()).ifPresent(builder::setParametricScheduleModelSequence2);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricScheduleModel _that = getType().cast(o);
		
			if (!Objects.equals(parametricScheduleModelSequence0, _that.getParametricScheduleModelSequence0())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(parametricScheduleModelSequence1, _that.getParametricScheduleModelSequence1())) return false;
			if (!Objects.equals(parametricScheduleModelSequence2, _that.getParametricScheduleModelSequence2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parametricScheduleModelSequence0 != null ? parametricScheduleModelSequence0.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (parametricScheduleModelSequence1 != null ? parametricScheduleModelSequence1.hashCode() : 0);
			_result = 31 * _result + (parametricScheduleModelSequence2 != null ? parametricScheduleModelSequence2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricScheduleModel {" +
				"parametricScheduleModelSequence0=" + this.parametricScheduleModelSequence0 + ", " +
				"endDate=" + this.endDate + ", " +
				"parametricScheduleModelSequence1=" + this.parametricScheduleModelSequence1 + ", " +
				"parametricScheduleModelSequence2=" + this.parametricScheduleModelSequence2 +
			'}';
		}
	}

	/*********************** Builder Implementation of ParametricScheduleModel  ***********************/
	class ParametricScheduleModelBuilderImpl implements ParametricScheduleModel.ParametricScheduleModelBuilder {
	
		protected ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder parametricScheduleModelSequence0;
		protected Date endDate;
		protected ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder parametricScheduleModelSequence1;
		protected ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder parametricScheduleModelSequence2;
	
		public ParametricScheduleModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("parametricScheduleModelSequence0")
		public ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder getParametricScheduleModelSequence0() {
			return parametricScheduleModelSequence0;
		}
		
		@Override
		public ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder getOrCreateParametricScheduleModelSequence0() {
			ParametricScheduleModelSequence0.ParametricScheduleModelSequence0Builder result;
			if (parametricScheduleModelSequence0!=null) {
				result = parametricScheduleModelSequence0;
			}
			else {
				result = parametricScheduleModelSequence0 = ParametricScheduleModelSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("endDate")
		public Date getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("parametricScheduleModelSequence1")
		public ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder getParametricScheduleModelSequence1() {
			return parametricScheduleModelSequence1;
		}
		
		@Override
		public ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder getOrCreateParametricScheduleModelSequence1() {
			ParametricScheduleModelSequence1.ParametricScheduleModelSequence1Builder result;
			if (parametricScheduleModelSequence1!=null) {
				result = parametricScheduleModelSequence1;
			}
			else {
				result = parametricScheduleModelSequence1 = ParametricScheduleModelSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("parametricScheduleModelSequence2")
		public ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder getParametricScheduleModelSequence2() {
			return parametricScheduleModelSequence2;
		}
		
		@Override
		public ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder getOrCreateParametricScheduleModelSequence2() {
			ParametricScheduleModelSequence2.ParametricScheduleModelSequence2Builder result;
			if (parametricScheduleModelSequence2!=null) {
				result = parametricScheduleModelSequence2;
			}
			else {
				result = parametricScheduleModelSequence2 = ParametricScheduleModelSequence2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("parametricScheduleModelSequence0")
		public ParametricScheduleModel.ParametricScheduleModelBuilder setParametricScheduleModelSequence0(ParametricScheduleModelSequence0 parametricScheduleModelSequence0) {
			this.parametricScheduleModelSequence0 = parametricScheduleModelSequence0==null?null:parametricScheduleModelSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("endDate")
		public ParametricScheduleModel.ParametricScheduleModelBuilder setEndDate(Date endDate) {
			this.endDate = endDate==null?null:endDate;
			return this;
		}
		@Override
		@RosettaAttribute("parametricScheduleModelSequence1")
		public ParametricScheduleModel.ParametricScheduleModelBuilder setParametricScheduleModelSequence1(ParametricScheduleModelSequence1 parametricScheduleModelSequence1) {
			this.parametricScheduleModelSequence1 = parametricScheduleModelSequence1==null?null:parametricScheduleModelSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("parametricScheduleModelSequence2")
		public ParametricScheduleModel.ParametricScheduleModelBuilder setParametricScheduleModelSequence2(ParametricScheduleModelSequence2 parametricScheduleModelSequence2) {
			this.parametricScheduleModelSequence2 = parametricScheduleModelSequence2==null?null:parametricScheduleModelSequence2.toBuilder();
			return this;
		}
		
		@Override
		public ParametricScheduleModel build() {
			return new ParametricScheduleModel.ParametricScheduleModelImpl(this);
		}
		
		@Override
		public ParametricScheduleModel.ParametricScheduleModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricScheduleModel.ParametricScheduleModelBuilder prune() {
			if (parametricScheduleModelSequence0!=null && !parametricScheduleModelSequence0.prune().hasData()) parametricScheduleModelSequence0 = null;
			if (parametricScheduleModelSequence1!=null && !parametricScheduleModelSequence1.prune().hasData()) parametricScheduleModelSequence1 = null;
			if (parametricScheduleModelSequence2!=null && !parametricScheduleModelSequence2.prune().hasData()) parametricScheduleModelSequence2 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParametricScheduleModelSequence0()!=null && getParametricScheduleModelSequence0().hasData()) return true;
			if (getEndDate()!=null) return true;
			if (getParametricScheduleModelSequence1()!=null && getParametricScheduleModelSequence1().hasData()) return true;
			if (getParametricScheduleModelSequence2()!=null && getParametricScheduleModelSequence2().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricScheduleModel.ParametricScheduleModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ParametricScheduleModel.ParametricScheduleModelBuilder o = (ParametricScheduleModel.ParametricScheduleModelBuilder) other;
			
			merger.mergeRosetta(getParametricScheduleModelSequence0(), o.getParametricScheduleModelSequence0(), this::setParametricScheduleModelSequence0);
			merger.mergeRosetta(getParametricScheduleModelSequence1(), o.getParametricScheduleModelSequence1(), this::setParametricScheduleModelSequence1);
			merger.mergeRosetta(getParametricScheduleModelSequence2(), o.getParametricScheduleModelSequence2(), this::setParametricScheduleModelSequence2);
			
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricScheduleModel _that = getType().cast(o);
		
			if (!Objects.equals(parametricScheduleModelSequence0, _that.getParametricScheduleModelSequence0())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(parametricScheduleModelSequence1, _that.getParametricScheduleModelSequence1())) return false;
			if (!Objects.equals(parametricScheduleModelSequence2, _that.getParametricScheduleModelSequence2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (parametricScheduleModelSequence0 != null ? parametricScheduleModelSequence0.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (parametricScheduleModelSequence1 != null ? parametricScheduleModelSequence1.hashCode() : 0);
			_result = 31 * _result + (parametricScheduleModelSequence2 != null ? parametricScheduleModelSequence2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricScheduleModelBuilder {" +
				"parametricScheduleModelSequence0=" + this.parametricScheduleModelSequence0 + ", " +
				"endDate=" + this.endDate + ", " +
				"parametricScheduleModelSequence1=" + this.parametricScheduleModelSequence1 + ", " +
				"parametricScheduleModelSequence2=" + this.parametricScheduleModelSequence2 +
			'}';
		}
	}
}
