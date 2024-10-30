package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EntityType;
import fpml.confirmation.validation.EntityTypeTypeFormatValidator;
import fpml.confirmation.validation.EntityTypeValidator;
import fpml.confirmation.validation.exists.EntityTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EntityType.class)
public class EntityTypeMeta implements RosettaMetaData<EntityType> {

	@Override
	public List<Validator<? super EntityType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EntityType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EntityType> validator() {
		return new EntityTypeValidator();
	}

	@Override
	public Validator<? super EntityType> typeFormatValidator() {
		return new EntityTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EntityType, Set<String>> onlyExistsValidator() {
		return new EntityTypeOnlyExistsValidator();
	}
}
