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
import fpml.confirmation.FxTenorModel;
import fpml.confirmation.FxTenorModel.FxTenorModelBuilder;
import fpml.confirmation.FxTenorModel.FxTenorModelBuilderImpl;
import fpml.confirmation.FxTenorModel.FxTenorModelImpl;
import fpml.confirmation.FxTenorPeriodEnum;
import fpml.confirmation.Period;
import fpml.confirmation.meta.FxTenorModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTenorModel", builder=FxTenorModel.FxTenorModelBuilderImpl.class, version="${project.version}")
public interface FxTenorModel extends RosettaModelObject {

	FxTenorModelMeta metaData = new FxTenorModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A tenor expressed with a standard business term (i.e. Spot, TomorrowNext, etc.)
	 */
	FxTenorPeriodEnum getTenorName();
	/**
	 * A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
	 */
	Period getTenorPeriod();

	/*********************** Build Methods  ***********************/
	FxTenorModel build();
	
	FxTenorModel.FxTenorModelBuilder toBuilder();
	
	static FxTenorModel.FxTenorModelBuilder builder() {
		return new FxTenorModel.FxTenorModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTenorModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTenorModel> getType() {
		return FxTenorModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tenorName"), FxTenorPeriodEnum.class, getTenorName(), this);
		processRosetta(path.newSubPath("tenorPeriod"), processor, Period.class, getTenorPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTenorModelBuilder extends FxTenorModel, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateTenorPeriod();
		Period.PeriodBuilder getTenorPeriod();
		FxTenorModel.FxTenorModelBuilder setTenorName(FxTenorPeriodEnum tenorName);
		FxTenorModel.FxTenorModelBuilder setTenorPeriod(Period tenorPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tenorName"), FxTenorPeriodEnum.class, getTenorName(), this);
			processRosetta(path.newSubPath("tenorPeriod"), processor, Period.PeriodBuilder.class, getTenorPeriod());
		}
		

		FxTenorModel.FxTenorModelBuilder prune();
	}

	/*********************** Immutable Implementation of FxTenorModel  ***********************/
	class FxTenorModelImpl implements FxTenorModel {
		private final FxTenorPeriodEnum tenorName;
		private final Period tenorPeriod;
		
		protected FxTenorModelImpl(FxTenorModel.FxTenorModelBuilder builder) {
			this.tenorName = builder.getTenorName();
			this.tenorPeriod = ofNullable(builder.getTenorPeriod()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tenorName")
		public FxTenorPeriodEnum getTenorName() {
			return tenorName;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		public Period getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		public FxTenorModel build() {
			return this;
		}
		
		@Override
		public FxTenorModel.FxTenorModelBuilder toBuilder() {
			FxTenorModel.FxTenorModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTenorModel.FxTenorModelBuilder builder) {
			ofNullable(getTenorName()).ifPresent(builder::setTenorName);
			ofNullable(getTenorPeriod()).ifPresent(builder::setTenorPeriod);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTenorModel _that = getType().cast(o);
		
			if (!Objects.equals(tenorName, _that.getTenorName())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tenorName != null ? tenorName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTenorModel {" +
				"tenorName=" + this.tenorName + ", " +
				"tenorPeriod=" + this.tenorPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTenorModel  ***********************/
	class FxTenorModelBuilderImpl implements FxTenorModel.FxTenorModelBuilder {
	
		protected FxTenorPeriodEnum tenorName;
		protected Period.PeriodBuilder tenorPeriod;
	
		public FxTenorModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("tenorName")
		public FxTenorPeriodEnum getTenorName() {
			return tenorName;
		}
		
		@Override
		@RosettaAttribute("tenorPeriod")
		public Period.PeriodBuilder getTenorPeriod() {
			return tenorPeriod;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTenorPeriod() {
			Period.PeriodBuilder result;
			if (tenorPeriod!=null) {
				result = tenorPeriod;
			}
			else {
				result = tenorPeriod = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tenorName")
		public FxTenorModel.FxTenorModelBuilder setTenorName(FxTenorPeriodEnum tenorName) {
			this.tenorName = tenorName==null?null:tenorName;
			return this;
		}
		@Override
		@RosettaAttribute("tenorPeriod")
		public FxTenorModel.FxTenorModelBuilder setTenorPeriod(Period tenorPeriod) {
			this.tenorPeriod = tenorPeriod==null?null:tenorPeriod.toBuilder();
			return this;
		}
		
		@Override
		public FxTenorModel build() {
			return new FxTenorModel.FxTenorModelImpl(this);
		}
		
		@Override
		public FxTenorModel.FxTenorModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTenorModel.FxTenorModelBuilder prune() {
			if (tenorPeriod!=null && !tenorPeriod.prune().hasData()) tenorPeriod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTenorName()!=null) return true;
			if (getTenorPeriod()!=null && getTenorPeriod().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTenorModel.FxTenorModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTenorModel.FxTenorModelBuilder o = (FxTenorModel.FxTenorModelBuilder) other;
			
			merger.mergeRosetta(getTenorPeriod(), o.getTenorPeriod(), this::setTenorPeriod);
			
			merger.mergeBasic(getTenorName(), o.getTenorName(), this::setTenorName);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTenorModel _that = getType().cast(o);
		
			if (!Objects.equals(tenorName, _that.getTenorName())) return false;
			if (!Objects.equals(tenorPeriod, _that.getTenorPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tenorName != null ? tenorName.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tenorPeriod != null ? tenorPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTenorModelBuilder {" +
				"tenorName=" + this.tenorName + ", " +
				"tenorPeriod=" + this.tenorPeriod +
			'}';
		}
	}
}
