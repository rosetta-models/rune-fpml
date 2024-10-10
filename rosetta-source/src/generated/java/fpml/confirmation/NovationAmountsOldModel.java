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
import fpml.confirmation.NovationAmountsOldModel;
import fpml.confirmation.NovationAmountsOldModel.NovationAmountsOldModelBuilder;
import fpml.confirmation.NovationAmountsOldModel.NovationAmountsOldModelBuilderImpl;
import fpml.confirmation.NovationAmountsOldModel.NovationAmountsOldModelImpl;
import fpml.confirmation.NovationAmountsOldModelSequence0;
import fpml.confirmation.NovationAmountsOldModelSequence1;
import fpml.confirmation.NovationAmountsOldModelSequence2;
import fpml.confirmation.meta.NovationAmountsOldModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NovationAmountsOldModel", builder=NovationAmountsOldModel.NovationAmountsOldModelBuilderImpl.class, version="${project.version}")
public interface NovationAmountsOldModel extends RosettaModelObject {

	NovationAmountsOldModelMeta metaData = new NovationAmountsOldModelMeta();

	/*********************** Getter Methods  ***********************/
	NovationAmountsOldModelSequence0 getNovationAmountsOldModelSequence0();
	NovationAmountsOldModelSequence1 getNovationAmountsOldModelSequence1();
	NovationAmountsOldModelSequence2 getNovationAmountsOldModelSequence2();

	/*********************** Build Methods  ***********************/
	NovationAmountsOldModel build();
	
	NovationAmountsOldModel.NovationAmountsOldModelBuilder toBuilder();
	
	static NovationAmountsOldModel.NovationAmountsOldModelBuilder builder() {
		return new NovationAmountsOldModel.NovationAmountsOldModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NovationAmountsOldModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NovationAmountsOldModel> getType() {
		return NovationAmountsOldModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("novationAmountsOldModelSequence0"), processor, NovationAmountsOldModelSequence0.class, getNovationAmountsOldModelSequence0());
		processRosetta(path.newSubPath("novationAmountsOldModelSequence1"), processor, NovationAmountsOldModelSequence1.class, getNovationAmountsOldModelSequence1());
		processRosetta(path.newSubPath("novationAmountsOldModelSequence2"), processor, NovationAmountsOldModelSequence2.class, getNovationAmountsOldModelSequence2());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NovationAmountsOldModelBuilder extends NovationAmountsOldModel, RosettaModelObjectBuilder {
		NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder getOrCreateNovationAmountsOldModelSequence0();
		NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder getNovationAmountsOldModelSequence0();
		NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder getOrCreateNovationAmountsOldModelSequence1();
		NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder getNovationAmountsOldModelSequence1();
		NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder getOrCreateNovationAmountsOldModelSequence2();
		NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder getNovationAmountsOldModelSequence2();
		NovationAmountsOldModel.NovationAmountsOldModelBuilder setNovationAmountsOldModelSequence0(NovationAmountsOldModelSequence0 novationAmountsOldModelSequence0);
		NovationAmountsOldModel.NovationAmountsOldModelBuilder setNovationAmountsOldModelSequence1(NovationAmountsOldModelSequence1 novationAmountsOldModelSequence1);
		NovationAmountsOldModel.NovationAmountsOldModelBuilder setNovationAmountsOldModelSequence2(NovationAmountsOldModelSequence2 novationAmountsOldModelSequence2);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("novationAmountsOldModelSequence0"), processor, NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder.class, getNovationAmountsOldModelSequence0());
			processRosetta(path.newSubPath("novationAmountsOldModelSequence1"), processor, NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder.class, getNovationAmountsOldModelSequence1());
			processRosetta(path.newSubPath("novationAmountsOldModelSequence2"), processor, NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder.class, getNovationAmountsOldModelSequence2());
		}
		

		NovationAmountsOldModel.NovationAmountsOldModelBuilder prune();
	}

	/*********************** Immutable Implementation of NovationAmountsOldModel  ***********************/
	class NovationAmountsOldModelImpl implements NovationAmountsOldModel {
		private final NovationAmountsOldModelSequence0 novationAmountsOldModelSequence0;
		private final NovationAmountsOldModelSequence1 novationAmountsOldModelSequence1;
		private final NovationAmountsOldModelSequence2 novationAmountsOldModelSequence2;
		
		protected NovationAmountsOldModelImpl(NovationAmountsOldModel.NovationAmountsOldModelBuilder builder) {
			this.novationAmountsOldModelSequence0 = ofNullable(builder.getNovationAmountsOldModelSequence0()).map(f->f.build()).orElse(null);
			this.novationAmountsOldModelSequence1 = ofNullable(builder.getNovationAmountsOldModelSequence1()).map(f->f.build()).orElse(null);
			this.novationAmountsOldModelSequence2 = ofNullable(builder.getNovationAmountsOldModelSequence2()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("novationAmountsOldModelSequence0")
		public NovationAmountsOldModelSequence0 getNovationAmountsOldModelSequence0() {
			return novationAmountsOldModelSequence0;
		}
		
		@Override
		@RosettaAttribute("novationAmountsOldModelSequence1")
		public NovationAmountsOldModelSequence1 getNovationAmountsOldModelSequence1() {
			return novationAmountsOldModelSequence1;
		}
		
		@Override
		@RosettaAttribute("novationAmountsOldModelSequence2")
		public NovationAmountsOldModelSequence2 getNovationAmountsOldModelSequence2() {
			return novationAmountsOldModelSequence2;
		}
		
		@Override
		public NovationAmountsOldModel build() {
			return this;
		}
		
		@Override
		public NovationAmountsOldModel.NovationAmountsOldModelBuilder toBuilder() {
			NovationAmountsOldModel.NovationAmountsOldModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NovationAmountsOldModel.NovationAmountsOldModelBuilder builder) {
			ofNullable(getNovationAmountsOldModelSequence0()).ifPresent(builder::setNovationAmountsOldModelSequence0);
			ofNullable(getNovationAmountsOldModelSequence1()).ifPresent(builder::setNovationAmountsOldModelSequence1);
			ofNullable(getNovationAmountsOldModelSequence2()).ifPresent(builder::setNovationAmountsOldModelSequence2);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationAmountsOldModel _that = getType().cast(o);
		
			if (!Objects.equals(novationAmountsOldModelSequence0, _that.getNovationAmountsOldModelSequence0())) return false;
			if (!Objects.equals(novationAmountsOldModelSequence1, _that.getNovationAmountsOldModelSequence1())) return false;
			if (!Objects.equals(novationAmountsOldModelSequence2, _that.getNovationAmountsOldModelSequence2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (novationAmountsOldModelSequence0 != null ? novationAmountsOldModelSequence0.hashCode() : 0);
			_result = 31 * _result + (novationAmountsOldModelSequence1 != null ? novationAmountsOldModelSequence1.hashCode() : 0);
			_result = 31 * _result + (novationAmountsOldModelSequence2 != null ? novationAmountsOldModelSequence2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationAmountsOldModel {" +
				"novationAmountsOldModelSequence0=" + this.novationAmountsOldModelSequence0 + ", " +
				"novationAmountsOldModelSequence1=" + this.novationAmountsOldModelSequence1 + ", " +
				"novationAmountsOldModelSequence2=" + this.novationAmountsOldModelSequence2 +
			'}';
		}
	}

	/*********************** Builder Implementation of NovationAmountsOldModel  ***********************/
	class NovationAmountsOldModelBuilderImpl implements NovationAmountsOldModel.NovationAmountsOldModelBuilder {
	
		protected NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder novationAmountsOldModelSequence0;
		protected NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder novationAmountsOldModelSequence1;
		protected NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder novationAmountsOldModelSequence2;
	
		public NovationAmountsOldModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("novationAmountsOldModelSequence0")
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder getNovationAmountsOldModelSequence0() {
			return novationAmountsOldModelSequence0;
		}
		
		@Override
		public NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder getOrCreateNovationAmountsOldModelSequence0() {
			NovationAmountsOldModelSequence0.NovationAmountsOldModelSequence0Builder result;
			if (novationAmountsOldModelSequence0!=null) {
				result = novationAmountsOldModelSequence0;
			}
			else {
				result = novationAmountsOldModelSequence0 = NovationAmountsOldModelSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("novationAmountsOldModelSequence1")
		public NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder getNovationAmountsOldModelSequence1() {
			return novationAmountsOldModelSequence1;
		}
		
		@Override
		public NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder getOrCreateNovationAmountsOldModelSequence1() {
			NovationAmountsOldModelSequence1.NovationAmountsOldModelSequence1Builder result;
			if (novationAmountsOldModelSequence1!=null) {
				result = novationAmountsOldModelSequence1;
			}
			else {
				result = novationAmountsOldModelSequence1 = NovationAmountsOldModelSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("novationAmountsOldModelSequence2")
		public NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder getNovationAmountsOldModelSequence2() {
			return novationAmountsOldModelSequence2;
		}
		
		@Override
		public NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder getOrCreateNovationAmountsOldModelSequence2() {
			NovationAmountsOldModelSequence2.NovationAmountsOldModelSequence2Builder result;
			if (novationAmountsOldModelSequence2!=null) {
				result = novationAmountsOldModelSequence2;
			}
			else {
				result = novationAmountsOldModelSequence2 = NovationAmountsOldModelSequence2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("novationAmountsOldModelSequence0")
		public NovationAmountsOldModel.NovationAmountsOldModelBuilder setNovationAmountsOldModelSequence0(NovationAmountsOldModelSequence0 novationAmountsOldModelSequence0) {
			this.novationAmountsOldModelSequence0 = novationAmountsOldModelSequence0==null?null:novationAmountsOldModelSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("novationAmountsOldModelSequence1")
		public NovationAmountsOldModel.NovationAmountsOldModelBuilder setNovationAmountsOldModelSequence1(NovationAmountsOldModelSequence1 novationAmountsOldModelSequence1) {
			this.novationAmountsOldModelSequence1 = novationAmountsOldModelSequence1==null?null:novationAmountsOldModelSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("novationAmountsOldModelSequence2")
		public NovationAmountsOldModel.NovationAmountsOldModelBuilder setNovationAmountsOldModelSequence2(NovationAmountsOldModelSequence2 novationAmountsOldModelSequence2) {
			this.novationAmountsOldModelSequence2 = novationAmountsOldModelSequence2==null?null:novationAmountsOldModelSequence2.toBuilder();
			return this;
		}
		
		@Override
		public NovationAmountsOldModel build() {
			return new NovationAmountsOldModel.NovationAmountsOldModelImpl(this);
		}
		
		@Override
		public NovationAmountsOldModel.NovationAmountsOldModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationAmountsOldModel.NovationAmountsOldModelBuilder prune() {
			if (novationAmountsOldModelSequence0!=null && !novationAmountsOldModelSequence0.prune().hasData()) novationAmountsOldModelSequence0 = null;
			if (novationAmountsOldModelSequence1!=null && !novationAmountsOldModelSequence1.prune().hasData()) novationAmountsOldModelSequence1 = null;
			if (novationAmountsOldModelSequence2!=null && !novationAmountsOldModelSequence2.prune().hasData()) novationAmountsOldModelSequence2 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNovationAmountsOldModelSequence0()!=null && getNovationAmountsOldModelSequence0().hasData()) return true;
			if (getNovationAmountsOldModelSequence1()!=null && getNovationAmountsOldModelSequence1().hasData()) return true;
			if (getNovationAmountsOldModelSequence2()!=null && getNovationAmountsOldModelSequence2().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationAmountsOldModel.NovationAmountsOldModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NovationAmountsOldModel.NovationAmountsOldModelBuilder o = (NovationAmountsOldModel.NovationAmountsOldModelBuilder) other;
			
			merger.mergeRosetta(getNovationAmountsOldModelSequence0(), o.getNovationAmountsOldModelSequence0(), this::setNovationAmountsOldModelSequence0);
			merger.mergeRosetta(getNovationAmountsOldModelSequence1(), o.getNovationAmountsOldModelSequence1(), this::setNovationAmountsOldModelSequence1);
			merger.mergeRosetta(getNovationAmountsOldModelSequence2(), o.getNovationAmountsOldModelSequence2(), this::setNovationAmountsOldModelSequence2);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationAmountsOldModel _that = getType().cast(o);
		
			if (!Objects.equals(novationAmountsOldModelSequence0, _that.getNovationAmountsOldModelSequence0())) return false;
			if (!Objects.equals(novationAmountsOldModelSequence1, _that.getNovationAmountsOldModelSequence1())) return false;
			if (!Objects.equals(novationAmountsOldModelSequence2, _that.getNovationAmountsOldModelSequence2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (novationAmountsOldModelSequence0 != null ? novationAmountsOldModelSequence0.hashCode() : 0);
			_result = 31 * _result + (novationAmountsOldModelSequence1 != null ? novationAmountsOldModelSequence1.hashCode() : 0);
			_result = 31 * _result + (novationAmountsOldModelSequence2 != null ? novationAmountsOldModelSequence2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationAmountsOldModelBuilder {" +
				"novationAmountsOldModelSequence0=" + this.novationAmountsOldModelSequence0 + ", " +
				"novationAmountsOldModelSequence1=" + this.novationAmountsOldModelSequence1 + ", " +
				"novationAmountsOldModelSequence2=" + this.novationAmountsOldModelSequence2 +
			'}';
		}
	}
}
