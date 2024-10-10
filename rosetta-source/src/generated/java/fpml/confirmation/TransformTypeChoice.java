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
import fpml.confirmation.TransformTypeChoice;
import fpml.confirmation.TransformTypeChoice.TransformTypeChoiceBuilder;
import fpml.confirmation.TransformTypeChoice.TransformTypeChoiceBuilderImpl;
import fpml.confirmation.TransformTypeChoice.TransformTypeChoiceImpl;
import fpml.confirmation.meta.TransformTypeChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TransformTypeChoice", builder=TransformTypeChoice.TransformTypeChoiceBuilderImpl.class, version="${project.version}")
public interface TransformTypeChoice extends RosettaModelObject {

	TransformTypeChoiceMeta metaData = new TransformTypeChoiceMeta();

	/*********************** Getter Methods  ***********************/
	String getXPath();

	/*********************** Build Methods  ***********************/
	TransformTypeChoice build();
	
	TransformTypeChoice.TransformTypeChoiceBuilder toBuilder();
	
	static TransformTypeChoice.TransformTypeChoiceBuilder builder() {
		return new TransformTypeChoice.TransformTypeChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransformTypeChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TransformTypeChoice> getType() {
		return TransformTypeChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("xPath"), String.class, getXPath(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransformTypeChoiceBuilder extends TransformTypeChoice, RosettaModelObjectBuilder {
		TransformTypeChoice.TransformTypeChoiceBuilder setXPath(String xPath);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("xPath"), String.class, getXPath(), this);
		}
		

		TransformTypeChoice.TransformTypeChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of TransformTypeChoice  ***********************/
	class TransformTypeChoiceImpl implements TransformTypeChoice {
		private final String xPath;
		
		protected TransformTypeChoiceImpl(TransformTypeChoice.TransformTypeChoiceBuilder builder) {
			this.xPath = builder.getXPath();
		}
		
		@Override
		@RosettaAttribute("xPath")
		public String getXPath() {
			return xPath;
		}
		
		@Override
		public TransformTypeChoice build() {
			return this;
		}
		
		@Override
		public TransformTypeChoice.TransformTypeChoiceBuilder toBuilder() {
			TransformTypeChoice.TransformTypeChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransformTypeChoice.TransformTypeChoiceBuilder builder) {
			ofNullable(getXPath()).ifPresent(builder::setXPath);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransformTypeChoice _that = getType().cast(o);
		
			if (!Objects.equals(xPath, _that.getXPath())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (xPath != null ? xPath.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransformTypeChoice {" +
				"xPath=" + this.xPath +
			'}';
		}
	}

	/*********************** Builder Implementation of TransformTypeChoice  ***********************/
	class TransformTypeChoiceBuilderImpl implements TransformTypeChoice.TransformTypeChoiceBuilder {
	
		protected String xPath;
	
		public TransformTypeChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("xPath")
		public String getXPath() {
			return xPath;
		}
		
		@Override
		@RosettaAttribute("xPath")
		public TransformTypeChoice.TransformTypeChoiceBuilder setXPath(String xPath) {
			this.xPath = xPath==null?null:xPath;
			return this;
		}
		
		@Override
		public TransformTypeChoice build() {
			return new TransformTypeChoice.TransformTypeChoiceImpl(this);
		}
		
		@Override
		public TransformTypeChoice.TransformTypeChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransformTypeChoice.TransformTypeChoiceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getXPath()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransformTypeChoice.TransformTypeChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransformTypeChoice.TransformTypeChoiceBuilder o = (TransformTypeChoice.TransformTypeChoiceBuilder) other;
			
			
			merger.mergeBasic(getXPath(), o.getXPath(), this::setXPath);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransformTypeChoice _that = getType().cast(o);
		
			if (!Objects.equals(xPath, _that.getXPath())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (xPath != null ? xPath.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransformTypeChoiceBuilder {" +
				"xPath=" + this.xPath +
			'}';
		}
	}
}
