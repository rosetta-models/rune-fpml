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
import fpml.confirmation.Leg;
import fpml.confirmation.Leg.LegBuilder;
import fpml.confirmation.Leg.LegBuilderImpl;
import fpml.confirmation.Leg.LegImpl;
import fpml.confirmation.meta.LegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A supertype of leg. All swap legs extend this type.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Leg", builder=Leg.LegBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Leg extends RosettaModelObject {

	LegMeta metaData = new LegMeta();

	/*********************** Getter Methods  ***********************/
	String getId();

	/*********************** Build Methods  ***********************/
	Leg build();
	
	Leg.LegBuilder toBuilder();
	
	static Leg.LegBuilder builder() {
		return new Leg.LegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Leg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Leg> getType() {
		return Leg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegBuilder extends Leg, RosettaModelObjectBuilder {
		Leg.LegBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Leg.LegBuilder prune();
	}

	/*********************** Immutable Implementation of Leg  ***********************/
	class LegImpl implements Leg {
		private final String id;
		
		protected LegImpl(Leg.LegBuilder builder) {
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Leg build() {
			return this;
		}
		
		@Override
		public Leg.LegBuilder toBuilder() {
			Leg.LegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Leg.LegBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Leg _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Leg {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Leg  ***********************/
	class LegBuilderImpl implements Leg.LegBuilder {
	
		protected String id;
	
		public LegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("id")
		public Leg.LegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Leg build() {
			return new Leg.LegImpl(this);
		}
		
		@Override
		public Leg.LegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Leg.LegBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Leg.LegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Leg.LegBuilder o = (Leg.LegBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Leg _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegBuilder {" +
				"id=" + this.id +
			'}';
		}
	}
}
