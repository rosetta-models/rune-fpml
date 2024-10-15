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
import fpml.confirmation.ChangeEventsBaseModel;
import fpml.confirmation.ChangeEventsBaseModel.ChangeEventsBaseModelBuilder;
import fpml.confirmation.ChangeEventsBaseModel.ChangeEventsBaseModelBuilderImpl;
import fpml.confirmation.ChangeEventsBaseModel.ChangeEventsBaseModelImpl;
import fpml.confirmation.TradeChangeContent;
import fpml.confirmation.meta.ChangeEventsBaseModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice between change-related events.
 * @version ${project.version}
 */
@RosettaDataType(value="ChangeEventsBaseModel", builder=ChangeEventsBaseModel.ChangeEventsBaseModelBuilderImpl.class, version="${project.version}")
public interface ChangeEventsBaseModel extends RosettaModelObject {

	ChangeEventsBaseModelMeta metaData = new ChangeEventsBaseModelMeta();

	/*********************** Getter Methods  ***********************/
	TradeChangeContent getChange();

	/*********************** Build Methods  ***********************/
	ChangeEventsBaseModel build();
	
	ChangeEventsBaseModel.ChangeEventsBaseModelBuilder toBuilder();
	
	static ChangeEventsBaseModel.ChangeEventsBaseModelBuilder builder() {
		return new ChangeEventsBaseModel.ChangeEventsBaseModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ChangeEventsBaseModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ChangeEventsBaseModel> getType() {
		return ChangeEventsBaseModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("change"), processor, TradeChangeContent.class, getChange());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ChangeEventsBaseModelBuilder extends ChangeEventsBaseModel, RosettaModelObjectBuilder {
		TradeChangeContent.TradeChangeContentBuilder getOrCreateChange();
		TradeChangeContent.TradeChangeContentBuilder getChange();
		ChangeEventsBaseModel.ChangeEventsBaseModelBuilder setChange(TradeChangeContent change);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("change"), processor, TradeChangeContent.TradeChangeContentBuilder.class, getChange());
		}
		

		ChangeEventsBaseModel.ChangeEventsBaseModelBuilder prune();
	}

	/*********************** Immutable Implementation of ChangeEventsBaseModel  ***********************/
	class ChangeEventsBaseModelImpl implements ChangeEventsBaseModel {
		private final TradeChangeContent change;
		
		protected ChangeEventsBaseModelImpl(ChangeEventsBaseModel.ChangeEventsBaseModelBuilder builder) {
			this.change = ofNullable(builder.getChange()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("change")
		public TradeChangeContent getChange() {
			return change;
		}
		
		@Override
		public ChangeEventsBaseModel build() {
			return this;
		}
		
		@Override
		public ChangeEventsBaseModel.ChangeEventsBaseModelBuilder toBuilder() {
			ChangeEventsBaseModel.ChangeEventsBaseModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ChangeEventsBaseModel.ChangeEventsBaseModelBuilder builder) {
			ofNullable(getChange()).ifPresent(builder::setChange);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ChangeEventsBaseModel _that = getType().cast(o);
		
			if (!Objects.equals(change, _that.getChange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ChangeEventsBaseModel {" +
				"change=" + this.change +
			'}';
		}
	}

	/*********************** Builder Implementation of ChangeEventsBaseModel  ***********************/
	class ChangeEventsBaseModelBuilderImpl implements ChangeEventsBaseModel.ChangeEventsBaseModelBuilder {
	
		protected TradeChangeContent.TradeChangeContentBuilder change;
	
		public ChangeEventsBaseModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("change")
		public TradeChangeContent.TradeChangeContentBuilder getChange() {
			return change;
		}
		
		@Override
		public TradeChangeContent.TradeChangeContentBuilder getOrCreateChange() {
			TradeChangeContent.TradeChangeContentBuilder result;
			if (change!=null) {
				result = change;
			}
			else {
				result = change = TradeChangeContent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("change")
		public ChangeEventsBaseModel.ChangeEventsBaseModelBuilder setChange(TradeChangeContent change) {
			this.change = change==null?null:change.toBuilder();
			return this;
		}
		
		@Override
		public ChangeEventsBaseModel build() {
			return new ChangeEventsBaseModel.ChangeEventsBaseModelImpl(this);
		}
		
		@Override
		public ChangeEventsBaseModel.ChangeEventsBaseModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ChangeEventsBaseModel.ChangeEventsBaseModelBuilder prune() {
			if (change!=null && !change.prune().hasData()) change = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getChange()!=null && getChange().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ChangeEventsBaseModel.ChangeEventsBaseModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ChangeEventsBaseModel.ChangeEventsBaseModelBuilder o = (ChangeEventsBaseModel.ChangeEventsBaseModelBuilder) other;
			
			merger.mergeRosetta(getChange(), o.getChange(), this::setChange);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ChangeEventsBaseModel _that = getType().cast(o);
		
			if (!Objects.equals(change, _that.getChange())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ChangeEventsBaseModelBuilder {" +
				"change=" + this.change +
			'}';
		}
	}
}
