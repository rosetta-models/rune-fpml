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
import fpml.confirmation.CompressionModel;
import fpml.confirmation.CompressionModel.CompressionModelBuilder;
import fpml.confirmation.CompressionModel.CompressionModelBuilderImpl;
import fpml.confirmation.CompressionModel.CompressionModelImpl;
import fpml.confirmation.meta.CompressionModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group holding information about compressions affecting this trade/event.
 * @version ${project.version}
 */
@RosettaDataType(value="CompressionModel", builder=CompressionModel.CompressionModelBuilderImpl.class, version="${project.version}")
public interface CompressionModel extends RosettaModelObject {

	CompressionModelMeta metaData = new CompressionModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Compression information for the trade.
	 */
	CompressionActivity getCompressionActivity();

	/*********************** Build Methods  ***********************/
	CompressionModel build();
	
	CompressionModel.CompressionModelBuilder toBuilder();
	
	static CompressionModel.CompressionModelBuilder builder() {
		return new CompressionModel.CompressionModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CompressionModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CompressionModel> getType() {
		return CompressionModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("compressionActivity"), processor, CompressionActivity.class, getCompressionActivity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompressionModelBuilder extends CompressionModel, RosettaModelObjectBuilder {
		CompressionActivity.CompressionActivityBuilder getOrCreateCompressionActivity();
		CompressionActivity.CompressionActivityBuilder getCompressionActivity();
		CompressionModel.CompressionModelBuilder setCompressionActivity(CompressionActivity compressionActivity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("compressionActivity"), processor, CompressionActivity.CompressionActivityBuilder.class, getCompressionActivity());
		}
		

		CompressionModel.CompressionModelBuilder prune();
	}

	/*********************** Immutable Implementation of CompressionModel  ***********************/
	class CompressionModelImpl implements CompressionModel {
		private final CompressionActivity compressionActivity;
		
		protected CompressionModelImpl(CompressionModel.CompressionModelBuilder builder) {
			this.compressionActivity = ofNullable(builder.getCompressionActivity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("compressionActivity")
		public CompressionActivity getCompressionActivity() {
			return compressionActivity;
		}
		
		@Override
		public CompressionModel build() {
			return this;
		}
		
		@Override
		public CompressionModel.CompressionModelBuilder toBuilder() {
			CompressionModel.CompressionModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CompressionModel.CompressionModelBuilder builder) {
			ofNullable(getCompressionActivity()).ifPresent(builder::setCompressionActivity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionModel _that = getType().cast(o);
		
			if (!Objects.equals(compressionActivity, _that.getCompressionActivity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compressionActivity != null ? compressionActivity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionModel {" +
				"compressionActivity=" + this.compressionActivity +
			'}';
		}
	}

	/*********************** Builder Implementation of CompressionModel  ***********************/
	class CompressionModelBuilderImpl implements CompressionModel.CompressionModelBuilder {
	
		protected CompressionActivity.CompressionActivityBuilder compressionActivity;
	
		public CompressionModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("compressionActivity")
		public CompressionActivity.CompressionActivityBuilder getCompressionActivity() {
			return compressionActivity;
		}
		
		@Override
		public CompressionActivity.CompressionActivityBuilder getOrCreateCompressionActivity() {
			CompressionActivity.CompressionActivityBuilder result;
			if (compressionActivity!=null) {
				result = compressionActivity;
			}
			else {
				result = compressionActivity = CompressionActivity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compressionActivity")
		public CompressionModel.CompressionModelBuilder setCompressionActivity(CompressionActivity compressionActivity) {
			this.compressionActivity = compressionActivity==null?null:compressionActivity.toBuilder();
			return this;
		}
		
		@Override
		public CompressionModel build() {
			return new CompressionModel.CompressionModelImpl(this);
		}
		
		@Override
		public CompressionModel.CompressionModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionModel.CompressionModelBuilder prune() {
			if (compressionActivity!=null && !compressionActivity.prune().hasData()) compressionActivity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCompressionActivity()!=null && getCompressionActivity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompressionModel.CompressionModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CompressionModel.CompressionModelBuilder o = (CompressionModel.CompressionModelBuilder) other;
			
			merger.mergeRosetta(getCompressionActivity(), o.getCompressionActivity(), this::setCompressionActivity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompressionModel _that = getType().cast(o);
		
			if (!Objects.equals(compressionActivity, _that.getCompressionActivity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compressionActivity != null ? compressionActivity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompressionModelBuilder {" +
				"compressionActivity=" + this.compressionActivity +
			'}';
		}
	}
}
