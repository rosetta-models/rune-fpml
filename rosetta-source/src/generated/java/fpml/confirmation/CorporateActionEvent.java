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
import fpml.confirmation.BusinessEventIdentifier;
import fpml.confirmation.ChangeEvent;
import fpml.confirmation.ChangeEvent.ChangeEventBuilder;
import fpml.confirmation.ChangeEvent.ChangeEventBuilderImpl;
import fpml.confirmation.ChangeEvent.ChangeEventImpl;
import fpml.confirmation.CorporateActionEvent;
import fpml.confirmation.CorporateActionEvent.CorporateActionEventBuilder;
import fpml.confirmation.CorporateActionEvent.CorporateActionEventBuilderImpl;
import fpml.confirmation.CorporateActionEvent.CorporateActionEventImpl;
import fpml.confirmation.CorporateActionType;
import fpml.confirmation.meta.CorporateActionEventMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure indicating that a trade has changed due to a corporate action
 * @version ${project.version}
 */
@RosettaDataType(value="CorporateActionEvent", builder=CorporateActionEvent.CorporateActionEventBuilderImpl.class, version="${project.version}")
public interface CorporateActionEvent extends ChangeEvent {

	CorporateActionEventMeta metaData = new CorporateActionEventMeta();

	/*********************** Getter Methods  ***********************/
	CorporateActionType getType();

	/*********************** Build Methods  ***********************/
	CorporateActionEvent build();
	
	CorporateActionEvent.CorporateActionEventBuilder toBuilder();
	
	static CorporateActionEvent.CorporateActionEventBuilder builder() {
		return new CorporateActionEvent.CorporateActionEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorporateActionEvent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CorporateActionEvent> getType() {
		return CorporateActionEvent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("type"), processor, CorporateActionType.class, getType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorporateActionEventBuilder extends CorporateActionEvent, ChangeEvent.ChangeEventBuilder {
		CorporateActionType.CorporateActionTypeBuilder getOrCreateType();
		CorporateActionType.CorporateActionTypeBuilder getType();
		CorporateActionEvent.CorporateActionEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier0);
		CorporateActionEvent.CorporateActionEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier1, int _idx);
		CorporateActionEvent.CorporateActionEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier2);
		CorporateActionEvent.CorporateActionEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier3);
		CorporateActionEvent.CorporateActionEventBuilder setType(CorporateActionType type);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("type"), processor, CorporateActionType.CorporateActionTypeBuilder.class, getType());
		}
		

		CorporateActionEvent.CorporateActionEventBuilder prune();
	}

	/*********************** Immutable Implementation of CorporateActionEvent  ***********************/
	class CorporateActionEventImpl extends ChangeEvent.ChangeEventImpl implements CorporateActionEvent {
		private final CorporateActionType type;
		
		protected CorporateActionEventImpl(CorporateActionEvent.CorporateActionEventBuilder builder) {
			super(builder);
			this.type = ofNullable(builder.getType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		public CorporateActionType getType() {
			return type;
		}
		
		@Override
		public CorporateActionEvent build() {
			return this;
		}
		
		@Override
		public CorporateActionEvent.CorporateActionEventBuilder toBuilder() {
			CorporateActionEvent.CorporateActionEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorporateActionEvent.CorporateActionEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getType()).ifPresent(builder::setType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorporateActionEvent _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorporateActionEvent {" +
				"type=" + this.type +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CorporateActionEvent  ***********************/
	class CorporateActionEventBuilderImpl extends ChangeEvent.ChangeEventBuilderImpl  implements CorporateActionEvent.CorporateActionEventBuilder {
	
		protected CorporateActionType.CorporateActionTypeBuilder type;
	
		public CorporateActionEventBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("type")
		public CorporateActionType.CorporateActionTypeBuilder getType() {
			return type;
		}
		
		@Override
		public CorporateActionType.CorporateActionTypeBuilder getOrCreateType() {
			CorporateActionType.CorporateActionTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = CorporateActionType.builder();
			}
			
			return result;
		}
		
		@Override
		public CorporateActionEvent.CorporateActionEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public CorporateActionEvent.CorporateActionEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public CorporateActionEvent.CorporateActionEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("eventIdentifier")
		public CorporateActionEvent.CorporateActionEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("type")
		public CorporateActionEvent.CorporateActionEventBuilder setType(CorporateActionType type) {
			this.type = type==null?null:type.toBuilder();
			return this;
		}
		
		@Override
		public CorporateActionEvent build() {
			return new CorporateActionEvent.CorporateActionEventImpl(this);
		}
		
		@Override
		public CorporateActionEvent.CorporateActionEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorporateActionEvent.CorporateActionEventBuilder prune() {
			super.prune();
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getType()!=null && getType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorporateActionEvent.CorporateActionEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CorporateActionEvent.CorporateActionEventBuilder o = (CorporateActionEvent.CorporateActionEventBuilder) other;
			
			merger.mergeRosetta(getType(), o.getType(), this::setType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorporateActionEvent _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CorporateActionEventBuilder {" +
				"type=" + this.type +
			'}' + " " + super.toString();
		}
	}
}
