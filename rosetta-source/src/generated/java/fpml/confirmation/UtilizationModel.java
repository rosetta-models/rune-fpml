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
import fpml.confirmation.UtilizationModel;
import fpml.confirmation.UtilizationModel.UtilizationModelBuilder;
import fpml.confirmation.UtilizationModel.UtilizationModelBuilderImpl;
import fpml.confirmation.UtilizationModel.UtilizationModelImpl;
import fpml.confirmation.UtilizationModelSequence0;
import fpml.confirmation.UtilizationModelSequence1;
import fpml.confirmation.meta.UtilizationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model that describes the breakdown of the utilization profile against a single facility.
 * @version ${project.version}
 */
@RosettaDataType(value="UtilizationModel", builder=UtilizationModel.UtilizationModelBuilderImpl.class, version="${project.version}")
public interface UtilizationModel extends RosettaModelObject {

	UtilizationModelMeta metaData = new UtilizationModelMeta();

	/*********************** Getter Methods  ***********************/
	UtilizationModelSequence0 getUtilizationModelSequence0();
	UtilizationModelSequence1 getUtilizationModelSequence1();

	/*********************** Build Methods  ***********************/
	UtilizationModel build();
	
	UtilizationModel.UtilizationModelBuilder toBuilder();
	
	static UtilizationModel.UtilizationModelBuilder builder() {
		return new UtilizationModel.UtilizationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UtilizationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UtilizationModel> getType() {
		return UtilizationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("utilizationModelSequence0"), processor, UtilizationModelSequence0.class, getUtilizationModelSequence0());
		processRosetta(path.newSubPath("utilizationModelSequence1"), processor, UtilizationModelSequence1.class, getUtilizationModelSequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UtilizationModelBuilder extends UtilizationModel, RosettaModelObjectBuilder {
		UtilizationModelSequence0.UtilizationModelSequence0Builder getOrCreateUtilizationModelSequence0();
		UtilizationModelSequence0.UtilizationModelSequence0Builder getUtilizationModelSequence0();
		UtilizationModelSequence1.UtilizationModelSequence1Builder getOrCreateUtilizationModelSequence1();
		UtilizationModelSequence1.UtilizationModelSequence1Builder getUtilizationModelSequence1();
		UtilizationModel.UtilizationModelBuilder setUtilizationModelSequence0(UtilizationModelSequence0 utilizationModelSequence0);
		UtilizationModel.UtilizationModelBuilder setUtilizationModelSequence1(UtilizationModelSequence1 utilizationModelSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("utilizationModelSequence0"), processor, UtilizationModelSequence0.UtilizationModelSequence0Builder.class, getUtilizationModelSequence0());
			processRosetta(path.newSubPath("utilizationModelSequence1"), processor, UtilizationModelSequence1.UtilizationModelSequence1Builder.class, getUtilizationModelSequence1());
		}
		

		UtilizationModel.UtilizationModelBuilder prune();
	}

	/*********************** Immutable Implementation of UtilizationModel  ***********************/
	class UtilizationModelImpl implements UtilizationModel {
		private final UtilizationModelSequence0 utilizationModelSequence0;
		private final UtilizationModelSequence1 utilizationModelSequence1;
		
		protected UtilizationModelImpl(UtilizationModel.UtilizationModelBuilder builder) {
			this.utilizationModelSequence0 = ofNullable(builder.getUtilizationModelSequence0()).map(f->f.build()).orElse(null);
			this.utilizationModelSequence1 = ofNullable(builder.getUtilizationModelSequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("utilizationModelSequence0")
		public UtilizationModelSequence0 getUtilizationModelSequence0() {
			return utilizationModelSequence0;
		}
		
		@Override
		@RosettaAttribute("utilizationModelSequence1")
		public UtilizationModelSequence1 getUtilizationModelSequence1() {
			return utilizationModelSequence1;
		}
		
		@Override
		public UtilizationModel build() {
			return this;
		}
		
		@Override
		public UtilizationModel.UtilizationModelBuilder toBuilder() {
			UtilizationModel.UtilizationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UtilizationModel.UtilizationModelBuilder builder) {
			ofNullable(getUtilizationModelSequence0()).ifPresent(builder::setUtilizationModelSequence0);
			ofNullable(getUtilizationModelSequence1()).ifPresent(builder::setUtilizationModelSequence1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationModel _that = getType().cast(o);
		
			if (!Objects.equals(utilizationModelSequence0, _that.getUtilizationModelSequence0())) return false;
			if (!Objects.equals(utilizationModelSequence1, _that.getUtilizationModelSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (utilizationModelSequence0 != null ? utilizationModelSequence0.hashCode() : 0);
			_result = 31 * _result + (utilizationModelSequence1 != null ? utilizationModelSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationModel {" +
				"utilizationModelSequence0=" + this.utilizationModelSequence0 + ", " +
				"utilizationModelSequence1=" + this.utilizationModelSequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of UtilizationModel  ***********************/
	class UtilizationModelBuilderImpl implements UtilizationModel.UtilizationModelBuilder {
	
		protected UtilizationModelSequence0.UtilizationModelSequence0Builder utilizationModelSequence0;
		protected UtilizationModelSequence1.UtilizationModelSequence1Builder utilizationModelSequence1;
	
		public UtilizationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("utilizationModelSequence0")
		public UtilizationModelSequence0.UtilizationModelSequence0Builder getUtilizationModelSequence0() {
			return utilizationModelSequence0;
		}
		
		@Override
		public UtilizationModelSequence0.UtilizationModelSequence0Builder getOrCreateUtilizationModelSequence0() {
			UtilizationModelSequence0.UtilizationModelSequence0Builder result;
			if (utilizationModelSequence0!=null) {
				result = utilizationModelSequence0;
			}
			else {
				result = utilizationModelSequence0 = UtilizationModelSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("utilizationModelSequence1")
		public UtilizationModelSequence1.UtilizationModelSequence1Builder getUtilizationModelSequence1() {
			return utilizationModelSequence1;
		}
		
		@Override
		public UtilizationModelSequence1.UtilizationModelSequence1Builder getOrCreateUtilizationModelSequence1() {
			UtilizationModelSequence1.UtilizationModelSequence1Builder result;
			if (utilizationModelSequence1!=null) {
				result = utilizationModelSequence1;
			}
			else {
				result = utilizationModelSequence1 = UtilizationModelSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("utilizationModelSequence0")
		public UtilizationModel.UtilizationModelBuilder setUtilizationModelSequence0(UtilizationModelSequence0 utilizationModelSequence0) {
			this.utilizationModelSequence0 = utilizationModelSequence0==null?null:utilizationModelSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("utilizationModelSequence1")
		public UtilizationModel.UtilizationModelBuilder setUtilizationModelSequence1(UtilizationModelSequence1 utilizationModelSequence1) {
			this.utilizationModelSequence1 = utilizationModelSequence1==null?null:utilizationModelSequence1.toBuilder();
			return this;
		}
		
		@Override
		public UtilizationModel build() {
			return new UtilizationModel.UtilizationModelImpl(this);
		}
		
		@Override
		public UtilizationModel.UtilizationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationModel.UtilizationModelBuilder prune() {
			if (utilizationModelSequence0!=null && !utilizationModelSequence0.prune().hasData()) utilizationModelSequence0 = null;
			if (utilizationModelSequence1!=null && !utilizationModelSequence1.prune().hasData()) utilizationModelSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUtilizationModelSequence0()!=null && getUtilizationModelSequence0().hasData()) return true;
			if (getUtilizationModelSequence1()!=null && getUtilizationModelSequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationModel.UtilizationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UtilizationModel.UtilizationModelBuilder o = (UtilizationModel.UtilizationModelBuilder) other;
			
			merger.mergeRosetta(getUtilizationModelSequence0(), o.getUtilizationModelSequence0(), this::setUtilizationModelSequence0);
			merger.mergeRosetta(getUtilizationModelSequence1(), o.getUtilizationModelSequence1(), this::setUtilizationModelSequence1);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationModel _that = getType().cast(o);
		
			if (!Objects.equals(utilizationModelSequence0, _that.getUtilizationModelSequence0())) return false;
			if (!Objects.equals(utilizationModelSequence1, _that.getUtilizationModelSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (utilizationModelSequence0 != null ? utilizationModelSequence0.hashCode() : 0);
			_result = 31 * _result + (utilizationModelSequence1 != null ? utilizationModelSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationModelBuilder {" +
				"utilizationModelSequence0=" + this.utilizationModelSequence0 + ", " +
				"utilizationModelSequence1=" + this.utilizationModelSequence1 +
			'}';
		}
	}
}
