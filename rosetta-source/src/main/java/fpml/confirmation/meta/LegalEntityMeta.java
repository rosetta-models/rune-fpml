package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LegalEntity;
import fpml.confirmation.validation.LegalEntityTypeFormatValidator;
import fpml.confirmation.validation.LegalEntityValidator;
import fpml.confirmation.validation.exists.LegalEntityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LegalEntity.class)
public class LegalEntityMeta implements RosettaMetaData<LegalEntity> {

	@Override
	public List<Validator<? super LegalEntity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LegalEntity>create(fpml.confirmation.validation.datarule.LegalEntityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LegalEntity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LegalEntity> validator() {
		return new LegalEntityValidator();
	}

	@Override
	public Validator<? super LegalEntity> typeFormatValidator() {
		return new LegalEntityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalEntity, Set<String>> onlyExistsValidator() {
		return new LegalEntityOnlyExistsValidator();
	}
}
