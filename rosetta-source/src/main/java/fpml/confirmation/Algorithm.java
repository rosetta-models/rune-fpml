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
import fpml.confirmation.Algorithm;
import fpml.confirmation.Algorithm.AlgorithmBuilder;
import fpml.confirmation.Algorithm.AlgorithmBuilderImpl;
import fpml.confirmation.Algorithm.AlgorithmImpl;
import fpml.confirmation.AlgorithmRole;
import fpml.confirmation.meta.AlgorithmMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Algorithm", builder=Algorithm.AlgorithmBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Algorithm extends RosettaModelObject {

	AlgorithmMeta metaData = new AlgorithmMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the algorithm.
	 */
	String getName();
	/**
	 * The category of the function of the algorithm. The related individual performs the role specified in this field for the base party. For example, if the role is &quot;Trader&quot;, the related person acts acts or acted as the base party&#39;s trader.
	 */
	AlgorithmRole getRole();

	/*********************** Build Methods  ***********************/
	Algorithm build();
	
	Algorithm.AlgorithmBuilder toBuilder();
	
	static Algorithm.AlgorithmBuilder builder() {
		return new Algorithm.AlgorithmBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Algorithm> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Algorithm> getType() {
		return Algorithm.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("role"), processor, AlgorithmRole.class, getRole());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AlgorithmBuilder extends Algorithm, RosettaModelObjectBuilder {
		AlgorithmRole.AlgorithmRoleBuilder getOrCreateRole();
		AlgorithmRole.AlgorithmRoleBuilder getRole();
		Algorithm.AlgorithmBuilder setName(String name);
		Algorithm.AlgorithmBuilder setRole(AlgorithmRole role);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("role"), processor, AlgorithmRole.AlgorithmRoleBuilder.class, getRole());
		}
		

		Algorithm.AlgorithmBuilder prune();
	}

	/*********************** Immutable Implementation of Algorithm  ***********************/
	class AlgorithmImpl implements Algorithm {
		private final String name;
		private final AlgorithmRole role;
		
		protected AlgorithmImpl(Algorithm.AlgorithmBuilder builder) {
			this.name = builder.getName();
			this.role = ofNullable(builder.getRole()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("role")
		public AlgorithmRole getRole() {
			return role;
		}
		
		@Override
		public Algorithm build() {
			return this;
		}
		
		@Override
		public Algorithm.AlgorithmBuilder toBuilder() {
			Algorithm.AlgorithmBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Algorithm.AlgorithmBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getRole()).ifPresent(builder::setRole);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Algorithm _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Algorithm {" +
				"name=" + this.name + ", " +
				"role=" + this.role +
			'}';
		}
	}

	/*********************** Builder Implementation of Algorithm  ***********************/
	class AlgorithmBuilderImpl implements Algorithm.AlgorithmBuilder {
	
		protected String name;
		protected AlgorithmRole.AlgorithmRoleBuilder role;
	
		public AlgorithmBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("role")
		public AlgorithmRole.AlgorithmRoleBuilder getRole() {
			return role;
		}
		
		@Override
		public AlgorithmRole.AlgorithmRoleBuilder getOrCreateRole() {
			AlgorithmRole.AlgorithmRoleBuilder result;
			if (role!=null) {
				result = role;
			}
			else {
				result = role = AlgorithmRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("name")
		public Algorithm.AlgorithmBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("role")
		public Algorithm.AlgorithmBuilder setRole(AlgorithmRole role) {
			this.role = role==null?null:role.toBuilder();
			return this;
		}
		
		@Override
		public Algorithm build() {
			return new Algorithm.AlgorithmImpl(this);
		}
		
		@Override
		public Algorithm.AlgorithmBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Algorithm.AlgorithmBuilder prune() {
			if (role!=null && !role.prune().hasData()) role = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getRole()!=null && getRole().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Algorithm.AlgorithmBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Algorithm.AlgorithmBuilder o = (Algorithm.AlgorithmBuilder) other;
			
			merger.mergeRosetta(getRole(), o.getRole(), this::setRole);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Algorithm _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(role, _that.getRole())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (role != null ? role.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AlgorithmBuilder {" +
				"name=" + this.name + ", " +
				"role=" + this.role +
			'}';
		}
	}
}
