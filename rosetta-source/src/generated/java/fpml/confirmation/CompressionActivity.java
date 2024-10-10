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
import fpml.confirmation.CompressionActivity;
import fpml.confirmation.CompressionActivity.CompressionActivityBuilder;
import fpml.confirmation.CompressionActivity.CompressionActivityBuilderImpl;
import fpml.confirmation.CompressionActivity.CompressionActivityImpl;
import fpml.confirmation.CompressionActivitySequence0;
import fpml.confirmation.CompressionActivitySequence1;
import fpml.confirmation.CompressionType;
import fpml.confirmation.meta.CompressionActivityMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that shows how multiple trades have been combined into a result.
 * @version ${project.version}
 */
@RosettaDataType(value="CompressionActivity", builder=CompressionActivity.CompressionActivityBuilderImpl.class, version="${project.version}")
public interface CompressionActivity extends RosettaModelObject {

	CompressionActivityMeta metaData = new CompressionActivityMeta();

	/*********************** Getter Methods  ***********************/
	CompressionType getCompressionType();
	CompressionActivitySequence0 getCompressionActivitySequence0();
	CompressionActivitySequence1 getCompressionActivitySequence1();

	/*********************** Build Methods  ***********************/
	CompressionActivity build();
	
	CompressionActivity.CompressionActivityBuilder toBuilder();
	
	static CompressionActivity.CompressionActivityBuilder builder() {
		return new CompressionActivity.CompressionActivityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CompressionActivity> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CompressionActivity> getType() {
		return CompressionActivity.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("compressionType"), processor, CompressionType.class, getCompressionType());
		processRosetta(path.newSubPath("compressionActivitySequence0"), processor, CompressionActivitySequence0.class, getCompressionActivitySequence0());
		processRosetta(path.newSubPath("compressionActivitySequence1"), processor, CompressionActivitySequence1.class, getCompressionActivitySequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompressionActivityBuilder extends CompressionActivity, RosettaModelObjectBuilder {
		CompressionType.CompressionTypeBuilder getOrCreateCompressionType();
		CompressionType.CompressionTypeBuilder getCompressionType();
		CompressionActivitySequence0.CompressionActivitySequence0Builder getOrCreateCompressionActivitySequence0();
		CompressionActivitySequence0.CompressionActivitySequence0Builder getCompressionActivitySequence0();
		CompressionActivitySequence1.CompressionActivitySequence1Builder getOrCreateCompressionActivitySequence1();
		CompressionActivitySequence1.CompressionActivitySequence1Builder getCompressionActivitySequence1();
		CompressionActivity.CompressionActivityBuilder setCompressionType(CompressionType compressionType);
		CompressionActivity.CompressionActivityBuilder setCompressionActivitySequence0(CompressionActivitySequence0 compressionActivitySequence0);
		CompressionActivity.CompressionActivityBuilder setCompressionActivitySequence1(CompressionActivitySequence1 compressionActivitySequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("compressionType"), processor, CompressionType.CompressionTypeBuilder.class, getCompressionType());
			processRosetta(path.newSubPath("compressionActivitySequence0"), processor, CompressionActivitySequence0.CompressionActivitySequence0Builder.class, getCompressionActivitySequence0());
			processRosetta(path.newSubPath("compressionActivitySequence1"), processor, CompressionActivitySequence1.CompressionActivitySequence1Builder.class, getCompressionActivitySequence1());
		}
		

		CompressionActivity.CompressionActivityBuilder prune();
	}

	/*********************** Immutable Implementation of CompressionActivity  ***********************/
	class CompressionActivityImpl implements CompressionActivity {
		private final CompressionType compressionType;
		private final CompressionActivitySequence0 compressionActivitySequence0;
		private final CompressionActivitySequence1 compressionActivitySequence1;
		
		protected CompressionActivityImpl(CompressionActivity.CompressionActivityBuilder builder) {
			this.compressionType = ofNullable(builder.getCompressionType()).map(f->f.build()).orElse(null);
			this.compressionActivitySequence0 = ofNullable(builder.getCompressionActivitySequence0()).map(f->f.build()).orElse(null);
			this.compressionActivitySequence1 = ofNullable(builder.getCompressionActivitySequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("compressionType")
		public CompressionType getCompressionType() {
			return compressionType;
		}
		
		@Override
		@RosettaAttribute("compressionActivitySequence0")
		public CompressionActivitySequence0 getCompressionActivitySequence0() {
			return compressionActivitySequence0;
		}
		
		@Override
		@RosettaAttribute("compressionActivitySequence1")
		public CompressionActivitySequence1 getCompressionActivitySequence1() {
			return compressionActivitySequence1;
		}
		
		@Override
		public CompressionActivity build() {
			return this;
		}
		
		@Override
		public CompressionActivity.CompressionActivityBuilder toBuilder() {
			CompressionActivity.CompressionActivityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CompressionActivity.CompressionActivityBuilder builder) {
			ofNullable(getCompressionType()).ifPresent(builder::setCompressionType);
			ofNullable(getCompressionActivitySequence0()).ifPresent(builder::setCompressionActivitySequence0);
			ofNullable(getCompressionActivitySequence1()).ifPresent(builder::setCompressionActivitySequence1);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionActivity _that = getType().cast(o);
		
			if (!Objects.equals(compressionType, _that.getCompressionType())) return false;
			if (!Objects.equals(compressionActivitySequence0, _that.getCompressionActivitySequence0())) return false;
			if (!Objects.equals(compressionActivitySequence1, _that.getCompressionActivitySequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compressionType != null ? compressionType.hashCode() : 0);
			_result = 31 * _result + (compressionActivitySequence0 != null ? compressionActivitySequence0.hashCode() : 0);
			_result = 31 * _result + (compressionActivitySequence1 != null ? compressionActivitySequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionActivity {" +
				"compressionType=" + this.compressionType + ", " +
				"compressionActivitySequence0=" + this.compressionActivitySequence0 + ", " +
				"compressionActivitySequence1=" + this.compressionActivitySequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of CompressionActivity  ***********************/
	class CompressionActivityBuilderImpl implements CompressionActivity.CompressionActivityBuilder {
	
		protected CompressionType.CompressionTypeBuilder compressionType;
		protected CompressionActivitySequence0.CompressionActivitySequence0Builder compressionActivitySequence0;
		protected CompressionActivitySequence1.CompressionActivitySequence1Builder compressionActivitySequence1;
	
		public CompressionActivityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("compressionType")
		public CompressionType.CompressionTypeBuilder getCompressionType() {
			return compressionType;
		}
		
		@Override
		public CompressionType.CompressionTypeBuilder getOrCreateCompressionType() {
			CompressionType.CompressionTypeBuilder result;
			if (compressionType!=null) {
				result = compressionType;
			}
			else {
				result = compressionType = CompressionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compressionActivitySequence0")
		public CompressionActivitySequence0.CompressionActivitySequence0Builder getCompressionActivitySequence0() {
			return compressionActivitySequence0;
		}
		
		@Override
		public CompressionActivitySequence0.CompressionActivitySequence0Builder getOrCreateCompressionActivitySequence0() {
			CompressionActivitySequence0.CompressionActivitySequence0Builder result;
			if (compressionActivitySequence0!=null) {
				result = compressionActivitySequence0;
			}
			else {
				result = compressionActivitySequence0 = CompressionActivitySequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compressionActivitySequence1")
		public CompressionActivitySequence1.CompressionActivitySequence1Builder getCompressionActivitySequence1() {
			return compressionActivitySequence1;
		}
		
		@Override
		public CompressionActivitySequence1.CompressionActivitySequence1Builder getOrCreateCompressionActivitySequence1() {
			CompressionActivitySequence1.CompressionActivitySequence1Builder result;
			if (compressionActivitySequence1!=null) {
				result = compressionActivitySequence1;
			}
			else {
				result = compressionActivitySequence1 = CompressionActivitySequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compressionType")
		public CompressionActivity.CompressionActivityBuilder setCompressionType(CompressionType compressionType) {
			this.compressionType = compressionType==null?null:compressionType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("compressionActivitySequence0")
		public CompressionActivity.CompressionActivityBuilder setCompressionActivitySequence0(CompressionActivitySequence0 compressionActivitySequence0) {
			this.compressionActivitySequence0 = compressionActivitySequence0==null?null:compressionActivitySequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("compressionActivitySequence1")
		public CompressionActivity.CompressionActivityBuilder setCompressionActivitySequence1(CompressionActivitySequence1 compressionActivitySequence1) {
			this.compressionActivitySequence1 = compressionActivitySequence1==null?null:compressionActivitySequence1.toBuilder();
			return this;
		}
		
		@Override
		public CompressionActivity build() {
			return new CompressionActivity.CompressionActivityImpl(this);
		}
		
		@Override
		public CompressionActivity.CompressionActivityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionActivity.CompressionActivityBuilder prune() {
			if (compressionType!=null && !compressionType.prune().hasData()) compressionType = null;
			if (compressionActivitySequence0!=null && !compressionActivitySequence0.prune().hasData()) compressionActivitySequence0 = null;
			if (compressionActivitySequence1!=null && !compressionActivitySequence1.prune().hasData()) compressionActivitySequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCompressionType()!=null && getCompressionType().hasData()) return true;
			if (getCompressionActivitySequence0()!=null && getCompressionActivitySequence0().hasData()) return true;
			if (getCompressionActivitySequence1()!=null && getCompressionActivitySequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionActivity.CompressionActivityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CompressionActivity.CompressionActivityBuilder o = (CompressionActivity.CompressionActivityBuilder) other;
			
			merger.mergeRosetta(getCompressionType(), o.getCompressionType(), this::setCompressionType);
			merger.mergeRosetta(getCompressionActivitySequence0(), o.getCompressionActivitySequence0(), this::setCompressionActivitySequence0);
			merger.mergeRosetta(getCompressionActivitySequence1(), o.getCompressionActivitySequence1(), this::setCompressionActivitySequence1);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionActivity _that = getType().cast(o);
		
			if (!Objects.equals(compressionType, _that.getCompressionType())) return false;
			if (!Objects.equals(compressionActivitySequence0, _that.getCompressionActivitySequence0())) return false;
			if (!Objects.equals(compressionActivitySequence1, _that.getCompressionActivitySequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compressionType != null ? compressionType.hashCode() : 0);
			_result = 31 * _result + (compressionActivitySequence0 != null ? compressionActivitySequence0.hashCode() : 0);
			_result = 31 * _result + (compressionActivitySequence1 != null ? compressionActivitySequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionActivityBuilder {" +
				"compressionType=" + this.compressionType + ", " +
				"compressionActivitySequence0=" + this.compressionActivitySequence0 + ", " +
				"compressionActivitySequence1=" + this.compressionActivitySequence1 +
			'}';
		}
	}
}
