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
import fpml.confirmation.OnBehalfOf;
import fpml.confirmation.OnBehalfOfModel;
import fpml.confirmation.OnBehalfOfModel.OnBehalfOfModelBuilder;
import fpml.confirmation.OnBehalfOfModel.OnBehalfOfModelBuilderImpl;
import fpml.confirmation.OnBehalfOfModel.OnBehalfOfModelImpl;
import fpml.confirmation.meta.OnBehalfOfModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OnBehalfOfModel", builder=OnBehalfOfModel.OnBehalfOfModelBuilderImpl.class, version="${project.version}")
public interface OnBehalfOfModel extends RosettaModelObject {

	OnBehalfOfModelMeta metaData = new OnBehalfOfModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates which party (or parties) (and accounts) a trade or event is being processed for. Normally there will only be a maximum of 2 parties, but in the case of a novation there could be a transferor, transferee, remaining party, and other remaining party. Also, in the context of a trade package there could be several parties for which limit check is requested, necessitating multiple onBehalfOf elements. Except for these cases, there should be no more than two onBehalfOf references in a message.
	 */
	OnBehalfOf getOnBehalfOf();

	/*********************** Build Methods  ***********************/
	OnBehalfOfModel build();
	
	OnBehalfOfModel.OnBehalfOfModelBuilder toBuilder();
	
	static OnBehalfOfModel.OnBehalfOfModelBuilder builder() {
		return new OnBehalfOfModel.OnBehalfOfModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OnBehalfOfModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OnBehalfOfModel> getType() {
		return OnBehalfOfModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OnBehalfOfModelBuilder extends OnBehalfOfModel, RosettaModelObjectBuilder {
		OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf();
		OnBehalfOf.OnBehalfOfBuilder getOnBehalfOf();
		OnBehalfOfModel.OnBehalfOfModelBuilder setOnBehalfOf(OnBehalfOf onBehalfOf);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
		}
		

		OnBehalfOfModel.OnBehalfOfModelBuilder prune();
	}

	/*********************** Immutable Implementation of OnBehalfOfModel  ***********************/
	class OnBehalfOfModelImpl implements OnBehalfOfModel {
		private final OnBehalfOf onBehalfOf;
		
		protected OnBehalfOfModelImpl(OnBehalfOfModel.OnBehalfOfModelBuilder builder) {
			this.onBehalfOf = ofNullable(builder.getOnBehalfOf()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		public OnBehalfOf getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		public OnBehalfOfModel build() {
			return this;
		}
		
		@Override
		public OnBehalfOfModel.OnBehalfOfModelBuilder toBuilder() {
			OnBehalfOfModel.OnBehalfOfModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OnBehalfOfModel.OnBehalfOfModelBuilder builder) {
			ofNullable(getOnBehalfOf()).ifPresent(builder::setOnBehalfOf);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OnBehalfOfModel _that = getType().cast(o);
		
			if (!Objects.equals(onBehalfOf, _that.getOnBehalfOf())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OnBehalfOfModel {" +
				"onBehalfOf=" + this.onBehalfOf +
			'}';
		}
	}

	/*********************** Builder Implementation of OnBehalfOfModel  ***********************/
	class OnBehalfOfModelBuilderImpl implements OnBehalfOfModel.OnBehalfOfModelBuilder {
	
		protected OnBehalfOf.OnBehalfOfBuilder onBehalfOf;
	
		public OnBehalfOfModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("onBehalfOf")
		public OnBehalfOf.OnBehalfOfBuilder getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf() {
			OnBehalfOf.OnBehalfOfBuilder result;
			if (onBehalfOf!=null) {
				result = onBehalfOf;
			}
			else {
				result = onBehalfOf = OnBehalfOf.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		public OnBehalfOfModel.OnBehalfOfModelBuilder setOnBehalfOf(OnBehalfOf onBehalfOf) {
			this.onBehalfOf = onBehalfOf==null?null:onBehalfOf.toBuilder();
			return this;
		}
		
		@Override
		public OnBehalfOfModel build() {
			return new OnBehalfOfModel.OnBehalfOfModelImpl(this);
		}
		
		@Override
		public OnBehalfOfModel.OnBehalfOfModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OnBehalfOfModel.OnBehalfOfModelBuilder prune() {
			if (onBehalfOf!=null && !onBehalfOf.prune().hasData()) onBehalfOf = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOnBehalfOf()!=null && getOnBehalfOf().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OnBehalfOfModel.OnBehalfOfModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OnBehalfOfModel.OnBehalfOfModelBuilder o = (OnBehalfOfModel.OnBehalfOfModelBuilder) other;
			
			merger.mergeRosetta(getOnBehalfOf(), o.getOnBehalfOf(), this::setOnBehalfOf);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OnBehalfOfModel _that = getType().cast(o);
		
			if (!Objects.equals(onBehalfOf, _that.getOnBehalfOf())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OnBehalfOfModelBuilder {" +
				"onBehalfOf=" + this.onBehalfOf +
			'}';
		}
	}
}
