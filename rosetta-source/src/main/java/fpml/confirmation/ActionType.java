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
import fpml.confirmation.ActionType;
import fpml.confirmation.ActionType.ActionTypeBuilder;
import fpml.confirmation.ActionType.ActionTypeBuilderImpl;
import fpml.confirmation.ActionType.ActionTypeImpl;
import fpml.confirmation.meta.ActionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The data type used for ESMA action type.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="ActionType", builder=ActionType.ActionTypeBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface ActionType extends RosettaModelObject {

	ActionTypeMeta metaData = new ActionTypeMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	/**
	 * The identifier scheme used with this actionType. A unique URI to determine the the type of action.
	 */
	String getActionTypeScheme();

	/*********************** Build Methods  ***********************/
	ActionType build();
	
	ActionType.ActionTypeBuilder toBuilder();
	
	static ActionType.ActionTypeBuilder builder() {
		return new ActionType.ActionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ActionType> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ActionType> getType() {
		return ActionType.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("actionTypeScheme"), String.class, getActionTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ActionTypeBuilder extends ActionType, RosettaModelObjectBuilder {
		ActionType.ActionTypeBuilder setValue(String value);
		ActionType.ActionTypeBuilder setActionTypeScheme(String actionTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("actionTypeScheme"), String.class, getActionTypeScheme(), this);
		}
		

		ActionType.ActionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ActionType  ***********************/
	class ActionTypeImpl implements ActionType {
		private final String value;
		private final String actionTypeScheme;
		
		protected ActionTypeImpl(ActionType.ActionTypeBuilder builder) {
			this.value = builder.getValue();
			this.actionTypeScheme = builder.getActionTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("actionTypeScheme")
		public String getActionTypeScheme() {
			return actionTypeScheme;
		}
		
		@Override
		public ActionType build() {
			return this;
		}
		
		@Override
		public ActionType.ActionTypeBuilder toBuilder() {
			ActionType.ActionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ActionType.ActionTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getActionTypeScheme()).ifPresent(builder::setActionTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(actionTypeScheme, _that.getActionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (actionTypeScheme != null ? actionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActionType {" +
				"value=" + this.value + ", " +
				"actionTypeScheme=" + this.actionTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ActionType  ***********************/
	class ActionTypeBuilderImpl implements ActionType.ActionTypeBuilder {
	
		protected String value;
		protected String actionTypeScheme;
	
		public ActionTypeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("actionTypeScheme")
		public String getActionTypeScheme() {
			return actionTypeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public ActionType.ActionTypeBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("actionTypeScheme")
		public ActionType.ActionTypeBuilder setActionTypeScheme(String actionTypeScheme) {
			this.actionTypeScheme = actionTypeScheme==null?null:actionTypeScheme;
			return this;
		}
		
		@Override
		public ActionType build() {
			return new ActionType.ActionTypeImpl(this);
		}
		
		@Override
		public ActionType.ActionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActionType.ActionTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getActionTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActionType.ActionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ActionType.ActionTypeBuilder o = (ActionType.ActionTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getActionTypeScheme(), o.getActionTypeScheme(), this::setActionTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(actionTypeScheme, _that.getActionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (actionTypeScheme != null ? actionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActionTypeBuilder {" +
				"value=" + this.value + ", " +
				"actionTypeScheme=" + this.actionTypeScheme +
			'}';
		}
	}
}
